package com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool;

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
import com.baidu.tieba.a68;
import com.baidu.tieba.ad5;
import com.baidu.tieba.bd5;
import com.baidu.tieba.fd5;
import com.baidu.tieba.ii;
import com.baidu.tieba.im.chat.ISendVoiceView;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.GroupChatFragment;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.robotfloor.GroupChatRobotFloorView;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.robotfloor.GroupChatRobotTopHeadView;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.robotfloor.GroupChatUserReplyView;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.BotsDTO;
import com.baidu.tieba.immessagecenter.chatgroup.utility.NoSlidingLinearLayout;
import com.baidu.tieba.jg;
import com.baidu.tieba.ke5;
import com.baidu.tieba.l1a;
import com.baidu.tieba.md5;
import com.baidu.tieba.pc5;
import com.baidu.tieba.q25;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.wi;
import com.baidu.tieba.xj9;
import com.baidu.tieba.yi;
import com.baidu.tieba.ze5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.regex.Pattern;
/* loaded from: classes4.dex */
public class GroupInputTool implements LifecycleObserver, yi {
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
        public static final Pattern v;
        public transient /* synthetic */ FieldHolder $fh;
        public md5 a;
        public EditorTools b;
        public RelativeLayout c;
        public RelativeLayout d;
        public NoSlidingLinearLayout e;
        public RelativeLayout f;
        public LinearLayout.LayoutParams g;
        public fd5 h;
        public ze5 i;
        public ad5 j;
        public NoSlidingLinearLayout k;
        public ISendVoiceView l;
        public GroupInputViewController m;
        public GroupChatRobotTopHeadView n;
        public GroupChatRobotFloorView o;
        public a68 p;
        public GroupChatUserReplyView q;
        public int r;
        public int s;
        public boolean t;
        public long u;

        /* loaded from: classes4.dex */
        public class a implements InputFilter {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

            /* renamed from: com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.GroupInputTool$g$a$a  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public class RunnableC0308a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                public RunnableC0308a(a aVar) {
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
                        String string = GroupInputTool.k.getString(R.string.obfuscated_res_0x7f0f0dcf);
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
                    if (this.a.L()) {
                        if (TextUtils.isEmpty(charSequence)) {
                            return charSequence;
                        }
                        boolean matches = g.v.matcher(charSequence.toString()).matches();
                        if (!matches) {
                            long currentTimeMillis = System.currentTimeMillis();
                            if (this.a.u == 0 || currentTimeMillis - this.a.u > 5000) {
                                this.a.u = currentTimeMillis;
                                jg.a().post(new RunnableC0308a(this));
                            }
                        }
                        if (!matches) {
                            return "";
                        }
                        return charSequence;
                    }
                    this.a.u = 0L;
                    return charSequence;
                }
                return (CharSequence) invokeCommon.objValue;
            }
        }

        /* loaded from: classes4.dex */
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
                if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && this.b.L() && this.a != null && editable != null && editable.length() > 1 && this.a.length() > 1 && this.a.charAt(0) == '0') {
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

        /* loaded from: classes4.dex */
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
            v = Pattern.compile("[0-9]");
        }

        public ISendVoiceView C() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.l;
            }
            return (ISendVoiceView) invokeV.objValue;
        }

        public EditorTools D() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.b;
            }
            return (EditorTools) invokeV.objValue;
        }

        public final void I() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                this.n = (GroupChatRobotTopHeadView) this.f.findViewById(R.id.obfuscated_res_0x7f0910a2);
            }
        }

        public final void K() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                this.q = (GroupChatUserReplyView) this.f.findViewById(R.id.obfuscated_res_0x7f090e40);
            }
        }

        public final boolean L() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                return this.t;
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
            this.r = R.color.CAM_X0212;
            this.t = false;
            this.u = 0L;
        }

        public static g B(@NonNull View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, view2)) == null) {
                g gVar = new g();
                gVar.c = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090e24);
                gVar.d = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091d5e);
                gVar.f = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090e1f);
                gVar.e = (NoSlidingLinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09068a);
                gVar.k = (NoSlidingLinearLayout) view2.findViewById(R.id.mask_view);
                return gVar;
            }
            return (g) invokeL.objValue;
        }

        public final void M(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
                this.b.y(i);
                P();
                NoSlidingLinearLayout noSlidingLinearLayout = this.k;
                if (noSlidingLinearLayout != null) {
                    noSlidingLinearLayout.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0608));
                }
                GroupChatRobotFloorView groupChatRobotFloorView = this.o;
                if (groupChatRobotFloorView != null) {
                    groupChatRobotFloorView.m(i);
                }
                GroupChatRobotTopHeadView groupChatRobotTopHeadView = this.n;
                if (groupChatRobotTopHeadView != null) {
                    groupChatRobotTopHeadView.d(i);
                }
                RelativeLayout relativeLayout = this.d;
                if (relativeLayout != null) {
                    q25.d(relativeLayout).f(R.color.CAM_X0207);
                }
                GroupChatUserReplyView groupChatUserReplyView = this.q;
                if (groupChatUserReplyView != null) {
                    groupChatUserReplyView.d(i);
                }
            }
        }

        public final void F(@NonNull SpanGroupEditText spanGroupEditText) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, spanGroupEditText) == null) {
                spanGroupEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000), new a(this)});
            }
        }

        public final void J(@NonNull SpanGroupEditText spanGroupEditText) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, spanGroupEditText) == null) {
                spanGroupEditText.addTextChangedListener(new b(this));
            }
        }

        public void N(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
                this.t = z;
            }
        }

        public void O(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
                this.s = i;
                P();
            }
        }

        public void A(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter) {
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
                ofInt.addListener(animatorListenerAdapter);
                ofInt.setTarget(this.f);
                ofInt.start();
            }
        }

        public final void E(GroupChatFragment groupChatFragment, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, groupChatFragment, context) == null) {
                md5 md5Var = new md5(context, true, false);
                this.a = md5Var;
                md5Var.j(true);
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
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001301, ad5.class, context);
                if (runTask != null && runTask.getData() != null) {
                    ad5 ad5Var = (ad5) runTask.getData();
                    this.j = ad5Var;
                    bd5 bd5Var = ad5Var.m;
                    if (bd5Var != null && (bd5Var instanceof ISendVoiceView)) {
                        this.l = (ISendVoiceView) bd5Var;
                    }
                    ad5 ad5Var2 = this.j;
                    ad5Var2.l = 1;
                    this.b.d(ad5Var2);
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(5);
                this.b.h(arrayList);
                ad5 p = this.b.p(5);
                if (p != null) {
                    p.f(true);
                    p.e(true);
                    p.d = 0;
                }
                this.b.d(this.a);
                fd5 fd5Var = new fd5(context);
                this.h = fd5Var;
                this.b.d(fd5Var);
                ze5 ze5Var = new ze5(context, true);
                this.i = ze5Var;
                this.b.d(ze5Var);
                this.b.f();
                this.c.addView(this.b, new ViewGroup.LayoutParams(-1, -2));
                bd5 bd5Var2 = this.a.m;
                if (bd5Var2 instanceof EditText) {
                    q25 d = q25.d((EditText) bd5Var2);
                    d.B(R.dimen.T_X06);
                    d.o(R.string.J_X07);
                    d.m(R.dimen.L_X01);
                    d.l(R.color.CAM_X0209);
                    d.u(SkinManager.getColor(TbadkCoreApplication.getInst().getSkinType(), this.r));
                }
                this.b.y(TbadkCoreApplication.getInst().getSkinType());
            }
        }

        public final void G(Context context) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048581, this, context) != null) || this.a.g() == null) {
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
            l1a.l(g, R.drawable.edittext_cursor);
            g.setLineSpacing(ii.g(context, R.dimen.M_T_X002), 1.0f);
            g.setPadding(ii.g(context, R.dimen.M_W_X006), ii.g(context, R.dimen.M_H_X004), ii.g(context, R.dimen.M_W_X006), ii.g(context, R.dimen.M_H_X004));
            F(g);
            J(g);
        }

        public final void H(GroupChatFragment groupChatFragment, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, groupChatFragment, context) == null) {
                GroupChatRobotFloorView groupChatRobotFloorView = (GroupChatRobotFloorView) this.f.findViewById(R.id.obfuscated_res_0x7f090e36);
                this.o = groupChatRobotFloorView;
                groupChatRobotFloorView.setPageContext(groupChatFragment.getPageContext());
                this.o.m(TbadkCoreApplication.getInst().getSkinType());
                a68 a68Var = new a68(groupChatFragment);
                this.p = a68Var;
                a68Var.r(this.o);
            }
        }

        public void P() {
            bd5 bd5Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
                int i = this.s;
                if (i == 0) {
                    this.r = SkinManager.getColor(R.color.CAM_X0212);
                } else if (i == 1) {
                    this.r = xj9.a(SkinManager.getColor(R.color.CAM_X0302), 0.06f);
                } else {
                    this.r = SkinManager.getColor(R.color.CAM_X0212);
                }
                md5 md5Var = this.a;
                if (md5Var != null && (bd5Var = md5Var.m) != null && (bd5Var instanceof EditText)) {
                    q25 d = q25.d((EditText) bd5Var);
                    d.B(R.dimen.T_X06);
                    d.o(R.string.J_X07);
                    d.m(R.dimen.L_X01);
                    d.l(R.color.CAM_X0209);
                    d.h(this.r);
                }
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
                    this.a.j.removeMessages(1);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements ke5.b {
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

        @Override // com.baidu.tieba.ke5.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (this.a.c != null) {
                    this.a.c.a(z, this.a.f);
                }
                this.a.e = z;
                this.a.H().m(z);
                this.a.e0(!z);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.H() != null && this.a.H().j()) {
                if (this.a.e) {
                    this.a.a.D().r();
                } else {
                    this.a.H().q(null);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements a68.e {
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

        @Override // com.baidu.tieba.a68.e
        public void a(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), animatorListenerAdapter, Boolean.valueOf(z)}) == null) {
                if (GroupInputTool.k != null) {
                    GroupInputTool.k.s2();
                }
                this.a.d0(false);
                this.a.R();
                this.a.r(i, i2, j, animatorListenerAdapter, z);
            }
        }

        @Override // com.baidu.tieba.a68.e
        public void b(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), animatorListenerAdapter, Boolean.valueOf(z)}) == null) {
                if (GroupInputTool.k != null) {
                    GroupInputTool.k.C2();
                }
                this.a.d0(true);
                this.a.q(i, i2, j, animatorListenerAdapter, z);
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
        S();
    }

    public void B(boolean z) {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && (gVar = this.a) != null && gVar.k != null) {
            this.a.k.setDisallowInterceptTouchEvent(z);
        }
    }

    public void W(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeI(1048596, this, i) != null) {
            return;
        }
        this.a.M(i);
    }

    public void X(@NonNull Bundle bundle) {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, bundle) == null) && (gVar = this.a) != null && gVar.m != null) {
            this.a.m.M0(bundle);
        }
    }

    public void Y(BotsDTO botsDTO) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048598, this, botsDTO) != null) || this.a.p == null) {
            return;
        }
        this.a.p.o(botsDTO);
    }

    public void Z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.f = z;
        }
    }

    public void a0(boolean z) {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048600, this, z) == null) && (gVar = this.a) != null) {
            gVar.N(z);
        }
    }

    public void b0(int i) {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048601, this, i) == null) && (gVar = this.a) != null) {
            gVar.O(i);
        }
    }

    public void c0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            b0(i);
        }
    }

    public void d0(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048603, this, z) == null) && this.a.b != null) {
            this.a.b.setTopShadowDividerVisible(z);
        }
    }

    public final void e0(boolean z) {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048604, this, z) != null) || (gVar = this.a) == null) {
            return;
        }
        if (z) {
            gVar.d.setVisibility(0);
        } else {
            gVar.d.setVisibility(8);
        }
    }

    public void f0(View.OnClickListener onClickListener) {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048605, this, onClickListener) == null) && onClickListener != null && (gVar = this.a) != null && gVar.k != null) {
            this.a.k.setOnClickListener(onClickListener);
        }
    }

    public void g0(boolean z) {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048606, this, z) == null) && (gVar = this.a) != null) {
            if (!z) {
                gVar.k.setVisibility(8);
            } else {
                gVar.k.setVisibility(0);
            }
        }
    }

    public void h0(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, fVar) == null) {
            this.c = fVar;
        }
    }

    public void i0(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, hVar) == null) {
            this.b = hVar;
        }
    }

    @Override // com.baidu.tieba.yi
    public void onDeletedVoice(String str) {
        h hVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048611, this, str) == null) && (hVar = this.b) != null) {
            hVar.a();
        }
    }

    @Override // com.baidu.tieba.yi
    public void onShowRecordTime(int i) {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048614, this, i) == null) && (gVar = this.a) != null && gVar.l != null) {
            this.a.l.onShowRecordTime(i);
        }
    }

    @Override // com.baidu.tieba.yi
    public void onShowRecording(int i) {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048615, this, i) == null) && (gVar = this.a) != null && gVar.l != null) {
            this.a.l.onShowRecording(i);
        }
    }

    public void z(boolean z) {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048622, this, z) == null) && (gVar = this.a) != null && gVar.e != null) {
            this.a.e.setDisallowInterceptTouchEvent(z);
        }
    }

    @Override // com.baidu.tieba.yi
    public void onSendVoice(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048612, this, str, i) == null) {
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
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            Handler handler = this.j;
            if (handler != null) {
                handler.removeMessages(1);
            }
            GroupChatFragment groupChatFragment = k;
            if (groupChatFragment != null && this.d != null) {
                ke5.c(groupChatFragment.requireActivity(), this.d);
            }
            k = null;
        }
    }

    @Nullable
    public fd5 C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            g gVar = this.a;
            if (gVar != null) {
                return gVar.h;
            }
            return null;
        }
        return (fd5) invokeV.objValue;
    }

    @Nullable
    public RelativeLayout D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            g gVar = this.a;
            if (gVar != null) {
                return gVar.c;
            }
            return null;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    @Nullable
    public md5 E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            g gVar = this.a;
            if (gVar != null) {
                return gVar.a;
            }
            return null;
        }
        return (md5) invokeV.objValue;
    }

    @Nullable
    public RelativeLayout F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            g gVar = this.a;
            if (gVar != null) {
                return gVar.f;
            }
            return null;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            g gVar = this.a;
            if (gVar == null || gVar.k.getVisibility() != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public a68 H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.a.p;
        }
        return (a68) invokeV.objValue;
    }

    public boolean I() {
        InterceptResult invokeV;
        View findViewById;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (F() == null || (findViewById = F().findViewById(R.id.obfuscated_res_0x7f090e1e)) == null || findViewById.getVisibility() != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Nullable
    public ze5 J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            g gVar = this.a;
            if (gVar != null) {
                return gVar.i;
            }
            return null;
        }
        return (ze5) invokeV.objValue;
    }

    @Nullable
    public ISendVoiceView K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            g gVar = this.a;
            if (gVar != null) {
                return gVar.C();
            }
            return null;
        }
        return (ISendVoiceView) invokeV.objValue;
    }

    public GroupChatRobotTopHeadView M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.a.n;
        }
        return (GroupChatRobotTopHeadView) invokeV.objValue;
    }

    @Nullable
    public EditorTools N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            g gVar = this.a;
            if (gVar != null) {
                return gVar.b;
            }
            return null;
        }
        return (EditorTools) invokeV.objValue;
    }

    public GroupChatUserReplyView O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            g gVar = this.a;
            if (gVar != null) {
                return gVar.q;
            }
            return null;
        }
        return (GroupChatUserReplyView) invokeV.objValue;
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048590, this) != null) || H() == null) {
            return;
        }
        H().n(new e(this));
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048591, this) != null) || this.a.k == null) {
            return;
        }
        this.a.k.setOnClickListener(new d(this));
    }

    public boolean T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.f;
        }
        return invokeV.booleanValue;
    }

    public boolean U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            g gVar = this.a;
            if (gVar != null && gVar.L()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.e;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.yi
    public boolean isOnCancle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            g gVar = this.a;
            if (gVar != null && gVar.l != null) {
                return this.a.l.isOnCancle();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.yi
    public void onStopingRecorder() {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048617, this) == null) && (gVar = this.a) != null && gVar.l != null) {
            this.a.l.onStopingRecorder();
        }
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            if (!this.e && !this.f) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            if (H() != null && H().j()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void P() {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (gVar = this.a) != null && gVar.D() != null) {
            this.f = false;
            this.a.D().r();
            this.a.D().s();
            this.a.D().C(new pc5(5, -1, null));
            f fVar = this.c;
            if (fVar != null) {
                fVar.a(this.e, this.f);
            }
        }
    }

    public final void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            g B = g.B(k.requireView());
            this.a = B;
            GroupChatFragment groupChatFragment = k;
            B.H(groupChatFragment, groupChatFragment.getContext());
            this.a.K();
            this.a.I();
            g gVar = this.a;
            GroupChatFragment groupChatFragment2 = k;
            gVar.E(groupChatFragment2, groupChatFragment2.getContext());
            this.a.G(k.getContext());
            FragmentActivity requireActivity = k.requireActivity();
            k.registerListener(this.i);
            Q();
            if (this.a.D() != null && this.a.D().b != null) {
                this.d = ke5.b(requireActivity, this.a.D().b, new c(this));
            }
        }
    }

    public void j0(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048610, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.g = j;
            this.h = j2;
            if (this.a.o != null) {
                this.a.o.setRoomDetailInfo(this.g, this.h);
            }
        }
    }

    @Override // com.baidu.tieba.yi
    public void onStartedRecorder(boolean z, int i) {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048616, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) && (gVar = this.a) != null && gVar.l != null) {
            this.a.l.onStartedRecorder(z, wi.c);
        }
    }

    @Override // com.baidu.tieba.yi
    public void onShowErr(int i, String str) {
        g gVar;
        GroupChatFragment groupChatFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048613, this, i, str) == null) && (gVar = this.a) != null && gVar.l != null) {
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

    public void q(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter, boolean z) {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048618, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), animatorListenerAdapter, Boolean.valueOf(z)}) == null) && (gVar = this.a) != null && gVar.f != null) {
            if (!z && G()) {
                g0(false);
            }
            this.a.A(i, i2, j, animatorListenerAdapter);
        }
    }

    public void r(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter, boolean z) {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048619, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), animatorListenerAdapter, Boolean.valueOf(z)}) == null) && (gVar = this.a) != null && gVar.f != null) {
            if (z && !G()) {
                g0(true);
            }
            this.a.A(i, i2, j, animatorListenerAdapter);
        }
    }
}
