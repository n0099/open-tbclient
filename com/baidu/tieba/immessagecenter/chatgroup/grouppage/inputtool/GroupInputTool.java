package com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool;

import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.InputFilter;
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
import com.baidu.tieba.bc5;
import com.baidu.tieba.ew7;
import com.baidu.tieba.ga9;
import com.baidu.tieba.gd5;
import com.baidu.tieba.hi;
import com.baidu.tieba.ic5;
import com.baidu.tieba.im.chat.ISendVoiceView;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.GroupChatFragment;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.GroupInputViewController;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.robotfloor.GroupChatRobotFloorView;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.robotfloor.GroupChatRobotTopHeadView;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.robotfloor.GroupChatUserReplyView;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.BotsDTO;
import com.baidu.tieba.immessagecenter.chatgroup.utility.NoSlidingLinearLayout;
import com.baidu.tieba.lb5;
import com.baidu.tieba.n15;
import com.baidu.tieba.ur9;
import com.baidu.tieba.vd5;
import com.baidu.tieba.vi;
import com.baidu.tieba.wb5;
import com.baidu.tieba.xb5;
import com.baidu.tieba.xi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class GroupInputTool implements LifecycleObserver, xi {
    public static /* synthetic */ Interceptable $ic;
    public static GroupChatFragment i;
    public transient /* synthetic */ FieldHolder $fh;
    public g a;
    public h b;
    public f c;
    public ViewTreeObserver.OnGlobalLayoutListener d;
    public boolean e;
    public boolean f;
    public final CustomMessageListener g;
    public final Handler h;

    /* loaded from: classes4.dex */
    public interface f {
        void a(boolean z, boolean z2);
    }

    /* loaded from: classes4.dex */
    public interface h {
        void a();

        void b(VoiceData.VoiceModel voiceModel);
    }

    /* loaded from: classes4.dex */
    public static class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ic5 a;
        public EditorTools b;
        public RelativeLayout c;
        public RelativeLayout d;
        public NoSlidingLinearLayout e;
        public RelativeLayout f;
        public LinearLayout.LayoutParams g;
        public bc5 h;
        public vd5 i;
        public wb5 j;
        public NoSlidingLinearLayout k;
        public ISendVoiceView l;
        public GroupInputViewController m;
        public GroupChatRobotTopHeadView n;
        public GroupChatRobotFloorView o;
        public ew7 p;
        public GroupChatUserReplyView q;
        public int r;
        public int s;

        /* loaded from: classes4.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ int b;
            public final /* synthetic */ int c;
            public final /* synthetic */ g d;

            public a(g gVar, int i, int i2, int i3) {
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

        public g() {
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
            this.r = R.color.CAM_X0212;
        }

        public final void C() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.n = (GroupChatRobotTopHeadView) this.f.findViewById(R.id.obfuscated_res_0x7f09109d);
            }
        }

        public final void D() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.q = (GroupChatUserReplyView) this.f.findViewById(R.id.obfuscated_res_0x7f090e3f);
            }
        }

        public ISendVoiceView x() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return this.l;
            }
            return (ISendVoiceView) invokeV.objValue;
        }

        public EditorTools y() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return this.b;
            }
            return (EditorTools) invokeV.objValue;
        }

        public void F(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
                this.s = i;
                G();
            }
        }

        public static g w(@NonNull View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, view2)) == null) {
                g gVar = new g();
                gVar.c = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090e24);
                gVar.d = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091d6f);
                gVar.f = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090e1f);
                gVar.e = (NoSlidingLinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090687);
                gVar.k = (NoSlidingLinearLayout) view2.findViewById(R.id.mask_view);
                return gVar;
            }
            return (g) invokeL.objValue;
        }

        public final void E(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
                this.b.y(i);
                G();
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
                    n15.d(relativeLayout).f(R.color.CAM_X0207);
                }
                GroupChatUserReplyView groupChatUserReplyView = this.q;
                if (groupChatUserReplyView != null) {
                    groupChatUserReplyView.d(i);
                }
            }
        }

        public final void A(Context context) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, context) != null) || this.a.g() == null) {
                return;
            }
            SpanGroupEditText g = this.a.g();
            g.setId(R.id.obfuscated_res_0x7f090e1d);
            g.setType(SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_DEFAULT);
            g.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.M_H_X003));
            g.setMaxLines(5);
            g.setMinLines(1);
            g.setGravity(48);
            g.setIncludeFontPadding(false);
            g.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.T_X06));
            g.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            g.setHintTextColor(context.getResources().getColor(R.color.CAM_X0109));
            ur9.l(g, R.drawable.edittext_cursor);
            g.setLineSpacing(hi.g(context, R.dimen.M_T_X002), 1.0f);
            g.setPadding(hi.g(context, R.dimen.M_W_X006), hi.g(context, R.dimen.M_H_X004), hi.g(context, R.dimen.M_W_X006), hi.g(context, R.dimen.M_H_X004));
            g.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        }

        public final void B(GroupChatFragment groupChatFragment, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, groupChatFragment, context) == null) {
                GroupChatRobotFloorView groupChatRobotFloorView = (GroupChatRobotFloorView) this.f.findViewById(R.id.obfuscated_res_0x7f090e35);
                this.o = groupChatRobotFloorView;
                groupChatRobotFloorView.setPageContext(groupChatFragment.getPageContext());
                this.o.l(TbadkCoreApplication.getInst().getSkinType());
                ew7 ew7Var = new ew7(groupChatFragment);
                this.p = ew7Var;
                ew7Var.o(this.o);
            }
        }

        public void G() {
            xb5 xb5Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                int i = this.s;
                if (i == 0) {
                    this.r = SkinManager.getColor(R.color.CAM_X0212);
                } else if (i == 1) {
                    this.r = ga9.a(SkinManager.getColor(R.color.CAM_X0302), 0.06f);
                } else {
                    this.r = SkinManager.getColor(R.color.CAM_X0212);
                }
                ic5 ic5Var = this.a;
                if (ic5Var != null && (xb5Var = ic5Var.m) != null && (xb5Var instanceof EditText)) {
                    n15 d = n15.d((EditText) xb5Var);
                    d.A(R.dimen.T_X06);
                    d.o(R.string.J_X07);
                    d.m(R.dimen.L_X01);
                    d.l(R.color.CAM_X0209);
                    d.h(this.r);
                }
            }
        }

        public void v(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), animatorListenerAdapter}) == null) {
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

        public final void z(GroupChatFragment groupChatFragment, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048586, this, groupChatFragment, context) == null) {
                ic5 ic5Var = new ic5(context, true, false);
                this.a = ic5Var;
                ic5Var.j(true);
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
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001301, wb5.class, context);
                if (runTask != null && runTask.getData() != null) {
                    wb5 wb5Var = (wb5) runTask.getData();
                    this.j = wb5Var;
                    xb5 xb5Var = wb5Var.m;
                    if (xb5Var != null && (xb5Var instanceof ISendVoiceView)) {
                        this.l = (ISendVoiceView) xb5Var;
                    }
                    wb5 wb5Var2 = this.j;
                    wb5Var2.l = 1;
                    this.b.d(wb5Var2);
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(5);
                this.b.h(arrayList);
                wb5 p = this.b.p(5);
                if (p != null) {
                    p.f(true);
                    p.e(true);
                    p.d = 0;
                }
                this.b.d(this.a);
                bc5 bc5Var = new bc5(context);
                this.h = bc5Var;
                this.b.d(bc5Var);
                vd5 vd5Var = new vd5(context, true);
                this.i = vd5Var;
                this.b.d(vd5Var);
                this.b.f();
                this.c.addView(this.b, new ViewGroup.LayoutParams(-1, -2));
                xb5 xb5Var2 = this.a.m;
                if (xb5Var2 instanceof EditText) {
                    n15 d = n15.d((EditText) xb5Var2);
                    d.A(R.dimen.T_X06);
                    d.o(R.string.J_X07);
                    d.m(R.dimen.L_X01);
                    d.l(R.color.CAM_X0209);
                    d.u(SkinManager.getColor(TbadkCoreApplication.getInst().getSkinType(), this.r));
                }
                this.b.y(TbadkCoreApplication.getInst().getSkinType());
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
    public class c implements gd5.b {
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

        @Override // com.baidu.tieba.gd5.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (this.a.c != null) {
                    this.a.c.a(z, this.a.f);
                }
                this.a.e = z;
                this.a.F().j(z);
                this.a.d0(!z);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921785, Boolean.valueOf(z)));
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.F() != null && this.a.F().h()) {
                if (this.a.e) {
                    this.a.a.y().r();
                } else {
                    this.a.F().n(null);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements ew7.e {
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

        @Override // com.baidu.tieba.ew7.e
        public void a(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), animatorListenerAdapter, Boolean.valueOf(z)}) == null) {
                if (GroupInputTool.i != null) {
                    GroupInputTool.i.o2();
                }
                this.a.c0(false);
                this.a.S();
                this.a.o(i, i2, j, animatorListenerAdapter, z);
            }
        }

        @Override // com.baidu.tieba.ew7.e
        public void b(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), animatorListenerAdapter, Boolean.valueOf(z)}) == null) {
                if (GroupInputTool.i != null) {
                    GroupInputTool.i.y2();
                }
                this.a.c0(true);
                this.a.n(i, i2, j, animatorListenerAdapter, z);
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
        T();
    }

    public void W(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeI(1048594, this, i2) != null) {
            return;
        }
        this.a.E(i2);
    }

    public void X(@NonNull Bundle bundle) {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, bundle) == null) && (gVar = this.a) != null && gVar.m != null) {
            this.a.m.I0(bundle);
        }
    }

    public void Y(BotsDTO botsDTO) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048596, this, botsDTO) != null) || this.a.p == null) {
            return;
        }
        this.a.p.l(botsDTO);
    }

    public void Z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.f = z;
        }
    }

    public void a0(int i2) {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048598, this, i2) == null) && (gVar = this.a) != null) {
            gVar.F(i2);
        }
    }

    public void b0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            a0(i2);
        }
    }

    public void c0(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048600, this, z) == null) && this.a.b != null) {
            this.a.b.setTopShadowDividerVisible(z);
        }
    }

    public final void d0(boolean z) {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048601, this, z) != null) || (gVar = this.a) == null) {
            return;
        }
        if (z) {
            gVar.d.setVisibility(0);
        } else {
            gVar.d.setVisibility(8);
        }
    }

    public void e0(View.OnClickListener onClickListener) {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, onClickListener) == null) && onClickListener != null && (gVar = this.a) != null && gVar.k != null) {
            this.a.k.setOnClickListener(onClickListener);
        }
    }

    public void f0(boolean z) {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048603, this, z) == null) && (gVar = this.a) != null) {
            if (!z) {
                gVar.k.setVisibility(8);
            } else {
                gVar.k.setVisibility(0);
            }
        }
    }

    public void g0(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, fVar) == null) {
            this.c = fVar;
        }
    }

    public void h0(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, hVar) == null) {
            this.b = hVar;
        }
    }

    @Override // com.baidu.tieba.xi
    public void onDeletedVoice(String str) {
        h hVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048609, this, str) == null) && (hVar = this.b) != null) {
            hVar.a();
        }
    }

    @Override // com.baidu.tieba.xi
    public void onShowRecordTime(int i2) {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048612, this, i2) == null) && (gVar = this.a) != null && gVar.l != null) {
            this.a.l.onShowRecordTime(i2);
        }
    }

    @Override // com.baidu.tieba.xi
    public void onShowRecording(int i2) {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048613, this, i2) == null) && (gVar = this.a) != null && gVar.l != null) {
            this.a.l.onShowRecording(i2);
        }
    }

    public void u(boolean z) {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048617, this, z) == null) && (gVar = this.a) != null && gVar.e != null) {
            this.a.e.setDisallowInterceptTouchEvent(z);
        }
    }

    public void x(boolean z) {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048618, this, z) == null) && (gVar = this.a) != null && gVar.k != null) {
            this.a.k.setDisallowInterceptTouchEvent(z);
        }
    }

    @Override // com.baidu.tieba.xi
    public void onSendVoice(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048610, this, str, i2) == null) {
            VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
            voiceModel.setDuration(i2);
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
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            Handler handler = this.h;
            if (handler != null) {
                handler.removeMessages(1);
            }
            GroupChatFragment groupChatFragment = i;
            if (groupChatFragment != null && this.d != null) {
                gd5.c(groupChatFragment.requireActivity(), this.d);
            }
            i = null;
        }
    }

    @Nullable
    public bc5 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            g gVar = this.a;
            if (gVar != null) {
                return gVar.h;
            }
            return null;
        }
        return (bc5) invokeV.objValue;
    }

    @Nullable
    public RelativeLayout B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            g gVar = this.a;
            if (gVar != null) {
                return gVar.c;
            }
            return null;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    @Nullable
    public ic5 C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            g gVar = this.a;
            if (gVar != null) {
                return gVar.a;
            }
            return null;
        }
        return (ic5) invokeV.objValue;
    }

    @Nullable
    public RelativeLayout D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            g gVar = this.a;
            if (gVar != null) {
                return gVar.f;
            }
            return null;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            g gVar = this.a;
            if (gVar == null || gVar.k.getVisibility() != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public ew7 F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.a.p;
        }
        return (ew7) invokeV.objValue;
    }

    public boolean G() {
        InterceptResult invokeV;
        View findViewById;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (D() == null || (findViewById = D().findViewById(R.id.obfuscated_res_0x7f090e1e)) == null || findViewById.getVisibility() != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Nullable
    public vd5 H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            g gVar = this.a;
            if (gVar != null) {
                return gVar.i;
            }
            return null;
        }
        return (vd5) invokeV.objValue;
    }

    @Nullable
    public ISendVoiceView J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            g gVar = this.a;
            if (gVar != null) {
                return gVar.x();
            }
            return null;
        }
        return (ISendVoiceView) invokeV.objValue;
    }

    public GroupChatRobotTopHeadView L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.a.n;
        }
        return (GroupChatRobotTopHeadView) invokeV.objValue;
    }

    @Nullable
    public EditorTools O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            g gVar = this.a;
            if (gVar != null) {
                return gVar.b;
            }
            return null;
        }
        return (EditorTools) invokeV.objValue;
    }

    public GroupChatUserReplyView P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            g gVar = this.a;
            if (gVar != null) {
                return gVar.q;
            }
            return null;
        }
        return (GroupChatUserReplyView) invokeV.objValue;
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048589, this) != null) || F() == null) {
            return;
        }
        F().k(new e(this));
    }

    public final void S() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048590, this) != null) || this.a.k == null) {
            return;
        }
        this.a.k.setOnClickListener(new d(this));
    }

    public boolean U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.f;
        }
        return invokeV.booleanValue;
    }

    public boolean V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.e;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.xi
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

    @Override // com.baidu.tieba.xi
    public void onStopingRecorder() {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048615, this) == null) && (gVar = this.a) != null && gVar.l != null) {
            this.a.l.onStopingRecorder();
        }
    }

    public void Q() {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (gVar = this.a) != null && gVar.y() != null) {
            this.f = false;
            this.a.y().r();
            this.a.y().s();
            this.a.y().C(new lb5(5, -1, null));
            f fVar = this.c;
            if (fVar != null) {
                fVar.a(this.e, this.f);
            }
        }
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            if (F() != null && F().h()) {
                return false;
            }
            if (i != null && G() && i.k2() != null && i.k2().t0() == GroupInputViewController.SourceType.TWO) {
                return false;
            }
            if (!this.e && !this.f) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            g w = g.w(i.requireView());
            this.a = w;
            GroupChatFragment groupChatFragment = i;
            w.B(groupChatFragment, groupChatFragment.getContext());
            this.a.D();
            this.a.C();
            g gVar = this.a;
            GroupChatFragment groupChatFragment2 = i;
            gVar.z(groupChatFragment2, groupChatFragment2.getContext());
            this.a.A(i.getContext());
            FragmentActivity requireActivity = i.requireActivity();
            i.registerListener(this.g);
            R();
            if (this.a.y() != null && this.a.y().b != null) {
                this.d = gd5.b(requireActivity, this.a.y().b, new c(this));
            }
        }
    }

    public void n(int i2, int i3, long j, AnimatorListenerAdapter animatorListenerAdapter, boolean z) {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), animatorListenerAdapter, Boolean.valueOf(z)}) == null) && (gVar = this.a) != null && gVar.f != null) {
            if (!z && E()) {
                f0(false);
            }
            this.a.v(i2, i3, j, animatorListenerAdapter);
        }
    }

    public void o(int i2, int i3, long j, AnimatorListenerAdapter animatorListenerAdapter, boolean z) {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), animatorListenerAdapter, Boolean.valueOf(z)}) == null) && (gVar = this.a) != null && gVar.f != null) {
            if (z && !E()) {
                f0(true);
            }
            this.a.v(i2, i3, j, animatorListenerAdapter);
        }
    }

    @Override // com.baidu.tieba.xi
    public void onShowErr(int i2, String str) {
        g gVar;
        GroupChatFragment groupChatFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048611, this, i2, str) == null) && (gVar = this.a) != null && gVar.l != null) {
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

    @Override // com.baidu.tieba.xi
    public void onStartedRecorder(boolean z, int i2) {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048614, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) && (gVar = this.a) != null && gVar.l != null) {
            this.a.l.onStartedRecorder(z, vi.c);
        }
    }
}
