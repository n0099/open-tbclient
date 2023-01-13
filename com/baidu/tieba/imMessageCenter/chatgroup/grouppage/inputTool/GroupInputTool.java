package com.baidu.tieba.imMessageCenter.chatgroup.grouppage.inputTool;

import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.InputFilter;
import android.view.MotionEvent;
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
import com.baidu.tieba.cx4;
import com.baidu.tieba.im.chat.ISendVoiceView;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.GroupChatFragment;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.inputTool.GroupInputViewController;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.inputTool.robotfloor.GroupChatRobotFloorView;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.inputTool.robotfloor.GroupChatRobotTopHeadView;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.repo.entity.BotsDTO;
import com.baidu.tieba.imMessageCenter.chatgroup.utility.NoSlidingLinearLayout;
import com.baidu.tieba.j95;
import com.baidu.tieba.k75;
import com.baidu.tieba.l75;
import com.baidu.tieba.lc9;
import com.baidu.tieba.ll5;
import com.baidu.tieba.nj;
import com.baidu.tieba.nv8;
import com.baidu.tieba.p75;
import com.baidu.tieba.pj;
import com.baidu.tieba.pl7;
import com.baidu.tieba.u85;
import com.baidu.tieba.w75;
import com.baidu.tieba.z65;
import com.baidu.tieba.zi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class GroupInputTool implements LifecycleObserver, pj {
    public static /* synthetic */ Interceptable $ic;
    public static GroupChatFragment i;
    public transient /* synthetic */ FieldHolder $fh;
    public i a;
    public j b;
    public h c;
    public ViewTreeObserver.OnGlobalLayoutListener d;
    public boolean e;
    public boolean f;
    public final CustomMessageListener g;
    public final Handler h;

    /* loaded from: classes4.dex */
    public interface h {
        void a(boolean z, boolean z2);
    }

    /* loaded from: classes4.dex */
    public interface j {
        void a();

        void b(VoiceData.VoiceModel voiceModel);
    }

    /* loaded from: classes4.dex */
    public static class i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public w75 a;
        public EditorTools b;
        public RelativeLayout c;
        public RelativeLayout d;
        public NoSlidingLinearLayout e;
        public RelativeLayout f;
        public LinearLayout.LayoutParams g;
        public p75 h;
        public j95 i;
        public k75 j;
        public NoSlidingLinearLayout k;
        public ISendVoiceView l;
        public GroupInputViewController m;
        public GroupChatRobotTopHeadView n;
        public GroupChatRobotFloorView o;
        public pl7 p;
        public int q;
        public int r;

        /* loaded from: classes4.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ int b;
            public final /* synthetic */ int c;
            public final /* synthetic */ i d;

            public a(i iVar, int i, int i2, int i3) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i4 = newInitContext.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.d = iVar;
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

        public i() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = null;
            this.b = null;
            this.j = null;
            this.l = null;
            this.q = R.color.CAM_X0212;
        }

        public final void A() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.n = (GroupChatRobotTopHeadView) this.f.findViewById(R.id.obfuscated_res_0x7f090fd3);
            }
        }

        public ISendVoiceView v() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.l;
            }
            return (ISendVoiceView) invokeV.objValue;
        }

        public EditorTools w() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.b;
            }
            return (EditorTools) invokeV.objValue;
        }

        public void C(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                this.r = i;
                D();
            }
        }

        public static i u(@NonNull View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, view2)) == null) {
                i iVar = new i();
                iVar.c = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090d62);
                iVar.d = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091c91);
                iVar.f = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090d5d);
                iVar.e = (NoSlidingLinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090615);
                iVar.k = (NoSlidingLinearLayout) view2.findViewById(R.id.mask_view);
                return iVar;
            }
            return (i) invokeL.objValue;
        }

        public final void B(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                this.b.y(i);
                D();
                NoSlidingLinearLayout noSlidingLinearLayout = this.k;
                if (noSlidingLinearLayout != null) {
                    noSlidingLinearLayout.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0608));
                }
                GroupChatRobotFloorView groupChatRobotFloorView = this.o;
                if (groupChatRobotFloorView != null) {
                    groupChatRobotFloorView.l(i);
                }
                GroupChatRobotTopHeadView groupChatRobotTopHeadView = this.n;
                if (groupChatRobotTopHeadView != null) {
                    groupChatRobotTopHeadView.d(i);
                }
                RelativeLayout relativeLayout = this.d;
                if (relativeLayout != null) {
                    cx4.d(relativeLayout).f(R.color.CAM_X0207);
                }
            }
        }

        public void D() {
            l75 l75Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                int i = this.r;
                if (i == 0) {
                    this.q = SkinManager.getColor(R.color.CAM_X0212);
                } else if (i == 1) {
                    this.q = nv8.a(SkinManager.getColor(R.color.CAM_X0302), 0.06f);
                } else {
                    this.q = SkinManager.getColor(R.color.CAM_X0212);
                }
                w75 w75Var = this.a;
                if (w75Var != null && (l75Var = w75Var.m) != null && (l75Var instanceof EditText)) {
                    cx4 d = cx4.d((EditText) l75Var);
                    d.z(R.dimen.T_X06);
                    d.n(R.string.J_X07);
                    d.l(R.dimen.L_X01);
                    d.k(R.color.CAM_X0209);
                    d.g(this.q);
                }
            }
        }

        public void t(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), animatorListenerAdapter}) == null) {
                int max = Math.max(i2, i);
                int i3 = max - ((i2 + i) - max);
                RelativeLayout relativeLayout = this.f;
                if (relativeLayout != null && (relativeLayout.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                    this.g = (LinearLayout.LayoutParams) this.f.getLayoutParams();
                }
                ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
                ofInt.setDuration(j);
                ofInt.addUpdateListener(new a(this, i3, i, i2));
                ofInt.addListener(animatorListenerAdapter);
                ofInt.setTarget(this.f);
                ofInt.start();
            }
        }

        public final void x(GroupChatFragment groupChatFragment, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, groupChatFragment, context) == null) {
                w75 w75Var = new w75(context, true, false);
                this.a = w75Var;
                w75Var.j(true);
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
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001301, k75.class, context);
                if (runTask != null && runTask.getData() != null) {
                    k75 k75Var = (k75) runTask.getData();
                    this.j = k75Var;
                    l75 l75Var = k75Var.m;
                    if (l75Var != null && (l75Var instanceof ISendVoiceView)) {
                        this.l = (ISendVoiceView) l75Var;
                    }
                    k75 k75Var2 = this.j;
                    k75Var2.l = 1;
                    this.b.d(k75Var2);
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(5);
                this.b.h(arrayList);
                k75 p = this.b.p(5);
                if (p != null) {
                    p.f(true);
                    p.e(true);
                    p.d = 0;
                }
                this.b.d(this.a);
                p75 p75Var = new p75(context);
                this.h = p75Var;
                this.b.d(p75Var);
                j95 j95Var = new j95(context, true);
                this.i = j95Var;
                this.b.d(j95Var);
                this.b.f();
                this.c.addView(this.b, new ViewGroup.LayoutParams(-1, -2));
                l75 l75Var2 = this.a.m;
                if (l75Var2 instanceof EditText) {
                    cx4 d = cx4.d((EditText) l75Var2);
                    d.z(R.dimen.T_X06);
                    d.n(R.string.J_X07);
                    d.l(R.dimen.L_X01);
                    d.k(R.color.CAM_X0209);
                    d.t(SkinManager.getColor(TbadkCoreApplication.getInst().getSkinType(), this.q));
                }
                this.b.y(TbadkCoreApplication.getInst().getSkinType());
            }
        }

        public final void y(Context context) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) != null) || this.a.g() == null) {
                return;
            }
            SpanGroupEditText g = this.a.g();
            g.setId(R.id.obfuscated_res_0x7f090d5b);
            g.setType(SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_DEFAULT);
            g.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.M_H_X003));
            g.setMaxLines(5);
            g.setMinLines(1);
            g.setGravity(48);
            g.setIncludeFontPadding(false);
            g.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.T_X06));
            g.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            g.setHintTextColor(context.getResources().getColor(R.color.CAM_X0109));
            lc9.l(g, R.drawable.edittext_cursor);
            g.setLineSpacing(zi.g(context, R.dimen.M_T_X002), 1.0f);
            g.setPadding(zi.g(context, R.dimen.M_W_X006), zi.g(context, R.dimen.M_H_X004), zi.g(context, R.dimen.M_W_X006), zi.g(context, R.dimen.M_H_X004));
            g.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        }

        public final void z(GroupChatFragment groupChatFragment, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, groupChatFragment, context) == null) {
                GroupChatRobotFloorView groupChatRobotFloorView = (GroupChatRobotFloorView) this.f.findViewById(R.id.obfuscated_res_0x7f090d72);
                this.o = groupChatRobotFloorView;
                groupChatRobotFloorView.setPageContext(groupChatFragment.getPageContext());
                this.o.l(TbadkCoreApplication.getInst().getSkinType());
                pl7 pl7Var = new pl7(groupChatFragment);
                this.p = pl7Var;
                pl7Var.o(this.o);
            }
        }
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
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
                    this.a.h.removeMessages(1);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements u85.b {
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

        @Override // com.baidu.tieba.u85.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (this.a.c != null) {
                    this.a.c.a(z, this.a.f);
                }
                this.a.e = z;
                this.a.A().j(z);
                this.a.S(!z);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921785, Boolean.valueOf(z)));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements ll5.c {
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

        @Override // com.baidu.tieba.ll5.c
        public void a(@NonNull MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, motionEvent) != null) || this.a.a == null || this.a.a.w() == null) {
                return;
            }
            this.a.f = false;
            this.a.a.w().r();
            this.a.a.w().s();
            this.a.a.w().C(new z65(5, -1, null));
            if (this.a.c != null) {
                this.a.c.a(this.a.e, this.a.f);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements ll5.d {
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

        @Override // com.baidu.tieba.ll5.d
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a.A() != null && this.a.A().h()) {
                    return false;
                }
                if (GroupInputTool.i != null && this.a.B() && GroupInputTool.i.Z1() != null && GroupInputTool.i.Z1().Y() == GroupInputViewController.SourceType.TWO) {
                    return false;
                }
                if (!this.a.e && !this.a.f) {
                    return false;
                }
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputTool a;

        public f(GroupInputTool groupInputTool) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.A() != null && this.a.A().h()) {
                if (this.a.e) {
                    this.a.a.w().r();
                } else {
                    this.a.A().n(null);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements pl7.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputTool a;

        public g(GroupInputTool groupInputTool) {
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

        @Override // com.baidu.tieba.pl7.e
        public void a(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), animatorListenerAdapter, Boolean.valueOf(z)}) == null) {
                if (GroupInputTool.i != null) {
                    GroupInputTool.i.a2();
                }
                this.a.R(false);
                this.a.I();
                this.a.n(i, i2, j, animatorListenerAdapter, z);
            }
        }

        @Override // com.baidu.tieba.pl7.e
        public void b(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), animatorListenerAdapter, Boolean.valueOf(z)}) == null) {
                if (GroupInputTool.i != null) {
                    GroupInputTool.i.g2();
                }
                this.a.R(true);
                this.a.m(i, i2, j, animatorListenerAdapter, z);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = new a(this, 2921776);
        this.h = new b(this);
        i = groupChatFragment;
    }

    public void L(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeI(1048586, this, i2) != null) {
            return;
        }
        this.a.B(i2);
    }

    public void M(@NonNull Bundle bundle) {
        i iVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) && (iVar = this.a) != null && iVar.m != null) {
            this.a.m.j0(bundle);
        }
    }

    public void N(BotsDTO botsDTO) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048588, this, botsDTO) != null) || this.a.p == null) {
            return;
        }
        this.a.p.l(botsDTO);
    }

    public void O(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.f = z;
        }
    }

    public void P(int i2) {
        i iVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048590, this, i2) == null) && (iVar = this.a) != null) {
            iVar.C(i2);
        }
    }

    public void Q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            P(i2);
        }
    }

    public void R(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048592, this, z) == null) && this.a.b != null) {
            this.a.b.setTopShadowDividerVisible(z);
        }
    }

    public final void S(boolean z) {
        i iVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048593, this, z) != null) || (iVar = this.a) == null) {
            return;
        }
        if (z) {
            iVar.d.setVisibility(0);
        } else {
            iVar.d.setVisibility(8);
        }
    }

    public void T(View.OnClickListener onClickListener) {
        i iVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, onClickListener) == null) && onClickListener != null && (iVar = this.a) != null && iVar.k != null) {
            this.a.k.setOnClickListener(onClickListener);
        }
    }

    public void U(boolean z) {
        i iVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048595, this, z) == null) && (iVar = this.a) != null) {
            if (!z) {
                iVar.k.setVisibility(8);
            } else {
                iVar.k.setVisibility(0);
            }
        }
    }

    public void V(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, hVar) == null) {
            this.c = hVar;
        }
    }

    public void W(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, jVar) == null) {
            this.b = jVar;
        }
    }

    @Override // com.baidu.tieba.pj
    public void onDeletedVoice(String str) {
        j jVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048601, this, str) == null) && (jVar = this.b) != null) {
            jVar.a();
        }
    }

    @Override // com.baidu.tieba.pj
    public void onShowRecordTime(int i2) {
        i iVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048604, this, i2) == null) && (iVar = this.a) != null && iVar.l != null) {
            this.a.l.onShowRecordTime(i2);
        }
    }

    @Override // com.baidu.tieba.pj
    public void onShowRecording(int i2) {
        i iVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048605, this, i2) == null) && (iVar = this.a) != null && iVar.l != null) {
            this.a.l.onShowRecording(i2);
        }
    }

    public void q(boolean z) {
        i iVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048608, this, z) == null) && (iVar = this.a) != null && iVar.e != null) {
            this.a.e.setDisallowInterceptTouchEvent(z);
        }
    }

    public void t(boolean z) {
        i iVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048609, this, z) == null) && (iVar = this.a) != null && iVar.k != null) {
            this.a.k.setDisallowInterceptTouchEvent(z);
        }
    }

    @Override // com.baidu.tieba.pj
    public void onSendVoice(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048602, this, str, i2) == null) {
            VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
            voiceModel.setDuration(i2);
            voiceModel.setVoiceId(str);
            voiceModel.voice_status = 1;
            j jVar = this.b;
            if (jVar != null) {
                jVar.b(voiceModel);
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            Handler handler = this.h;
            if (handler != null) {
                handler.removeMessages(1);
            }
            GroupChatFragment groupChatFragment = i;
            if (groupChatFragment != null && this.d != null) {
                u85.c(groupChatFragment.requireActivity(), this.d);
            }
            i = null;
        }
    }

    public pl7 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a.p;
        }
        return (pl7) invokeV.objValue;
    }

    public boolean B() {
        InterceptResult invokeV;
        View findViewById;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (y() == null || (findViewById = y().findViewById(R.id.obfuscated_res_0x7f090d5c)) == null || findViewById.getVisibility() != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Nullable
    public j95 D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            i iVar = this.a;
            if (iVar != null) {
                return iVar.i;
            }
            return null;
        }
        return (j95) invokeV.objValue;
    }

    @Nullable
    public ISendVoiceView E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            i iVar = this.a;
            if (iVar != null) {
                return iVar.v();
            }
            return null;
        }
        return (ISendVoiceView) invokeV.objValue;
    }

    public GroupChatRobotTopHeadView F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a.n;
        }
        return (GroupChatRobotTopHeadView) invokeV.objValue;
    }

    @Nullable
    public EditorTools G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            i iVar = this.a;
            if (iVar != null) {
                return iVar.b;
            }
            return null;
        }
        return (EditorTools) invokeV.objValue;
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || A() == null) {
            return;
        }
        A().k(new g(this));
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || this.a.k == null) {
            return;
        }
        this.a.k.setOnClickListener(new f(this));
    }

    public boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.f;
        }
        return invokeV.booleanValue;
    }

    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.e;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.pj
    public boolean isOnCancle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            i iVar = this.a;
            if (iVar != null && iVar.l != null) {
                return this.a.l.isOnCancle();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.pj
    public void onStopingRecorder() {
        i iVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048607, this) == null) && (iVar = this.a) != null && iVar.l != null) {
            this.a.l.onStopingRecorder();
        }
    }

    @Nullable
    public p75 u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            i iVar = this.a;
            if (iVar != null) {
                return iVar.h;
            }
            return null;
        }
        return (p75) invokeV.objValue;
    }

    @Nullable
    public RelativeLayout w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            i iVar = this.a;
            if (iVar != null) {
                return iVar.c;
            }
            return null;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    @Nullable
    public w75 x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            i iVar = this.a;
            if (iVar != null) {
                return iVar.a;
            }
            return null;
        }
        return (w75) invokeV.objValue;
    }

    @Nullable
    public RelativeLayout y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            i iVar = this.a;
            if (iVar != null) {
                return iVar.f;
            }
            return null;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            i iVar = this.a;
            if (iVar == null || iVar.k.getVisibility() != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            i u = i.u(i.requireView());
            this.a = u;
            GroupChatFragment groupChatFragment = i;
            u.z(groupChatFragment, groupChatFragment.getContext());
            this.a.A();
            i iVar = this.a;
            GroupChatFragment groupChatFragment2 = i;
            iVar.x(groupChatFragment2, groupChatFragment2.getContext());
            this.a.y(i.getContext());
            FragmentActivity requireActivity = i.requireActivity();
            i.registerListener(this.g);
            H();
            if (this.a.w() != null && this.a.w().b != null) {
                this.d = u85.b(requireActivity, this.a.w().b, new c(this));
            }
            ll5 g2 = ll5.g(requireActivity);
            g2.k(R.id.obfuscated_res_0x7f090d62, R.id.obfuscated_res_0x7f090d5c);
            g2.j(new e(this));
            g2.i(new d(this));
            g2.f();
        }
    }

    public void m(int i2, int i3, long j2, AnimatorListenerAdapter animatorListenerAdapter, boolean z) {
        i iVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2), animatorListenerAdapter, Boolean.valueOf(z)}) == null) && (iVar = this.a) != null && iVar.f != null) {
            if (!z && z()) {
                U(false);
            }
            this.a.t(i2, i3, j2, animatorListenerAdapter);
        }
    }

    public void n(int i2, int i3, long j2, AnimatorListenerAdapter animatorListenerAdapter, boolean z) {
        i iVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2), animatorListenerAdapter, Boolean.valueOf(z)}) == null) && (iVar = this.a) != null && iVar.f != null) {
            if (z && !z()) {
                U(true);
            }
            this.a.t(i2, i3, j2, animatorListenerAdapter);
        }
    }

    @Override // com.baidu.tieba.pj
    public void onShowErr(int i2, String str) {
        i iVar;
        GroupChatFragment groupChatFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048603, this, i2, str) == null) && (iVar = this.a) != null && iVar.l != null) {
            this.a.l.onShowErr(i2, str);
            if (!StringUtils.isNull(str) && (groupChatFragment = i) != null) {
                if (i2 == 3) {
                    groupChatFragment.showToast(str);
                    this.a.l.setRecoding(false);
                } else if (i2 == 2) {
                    Handler handler = this.h;
                    handler.sendMessageDelayed(handler.obtainMessage(1), 500L);
                } else {
                    groupChatFragment.showToast(str);
                }
            }
        }
    }

    @Override // com.baidu.tieba.pj
    public void onStartedRecorder(boolean z, int i2) {
        i iVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) && (iVar = this.a) != null && iVar.l != null) {
            this.a.l.onStartedRecorder(z, nj.c);
        }
    }
}
