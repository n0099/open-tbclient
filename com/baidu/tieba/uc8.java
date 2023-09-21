package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupEditText;
import com.baidu.tbadk.data.AtSelectData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.im.base.core.inputtool.GroupInputTool;
import com.baidu.tieba.im.base.core.inputtool.GroupInputViewController;
import com.baidu.tieba.im.base.core.inputtool.consts.ToolState;
import com.baidu.tieba.im.base.core.inputtool.data.InputBanData;
import com.baidu.tieba.lb5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class uc8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public Context a;
    @NonNull
    public final GroupInputViewController b;
    @Nullable
    public pd8 c;
    @Nullable
    public md8 d;
    @Nullable
    public GroupInputTool e;
    @Nullable
    public EditorTools f;
    public final Map<String, AtSelectData> g;
    public final Map<String, Integer> h;
    public ToolState i;
    public boolean j;
    public boolean k;
    public boolean l;
    public final Runnable m;
    public final CustomMessageListener n;
    public final CustomMessageListener o;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uc8 a;

        public a(uc8 uc8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uc8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uc8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                BdUtilHelper.showSoftKeyPad(this.a.a, this.a.s());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uc8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(uc8 uc8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uc8Var, Integer.valueOf(i)};
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
            this.a = uc8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && !customResponsedMessage.hasError() && (customResponsedMessage.getData() instanceof AtSelectData)) {
                this.a.x((AtSelectData) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uc8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(uc8 uc8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uc8Var, Integer.valueOf(i)};
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
            this.a = uc8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean) || !((Boolean) customResponsedMessage.getData()).booleanValue() || !this.a.l) {
                return;
            }
            this.a.l = false;
            this.a.b.s0(true, 3);
        }
    }

    /* loaded from: classes8.dex */
    public class d implements lb5.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpanGroupEditText a;
        public final /* synthetic */ uc8 b;

        public d(uc8 uc8Var, SpanGroupEditText spanGroupEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uc8Var, spanGroupEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = uc8Var;
            this.a = spanGroupEditText;
        }

        @Override // com.baidu.tieba.lb5.a
        public void f(int i, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) && this.b.g.size() != ListUtils.getCount(this.a.getSpanGroupManager().v())) {
                this.b.N(this.a.getSpanGroupManager().v());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpanGroupEditText a;
        public final /* synthetic */ uc8 b;

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
            }
        }

        public e(uc8 uc8Var, SpanGroupEditText spanGroupEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uc8Var, spanGroupEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = uc8Var;
            this.a = spanGroupEditText;
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
                if (charSequence == null || fy5.b(this.a) <= 0) {
                    this.b.j = true;
                } else {
                    this.b.j = false;
                }
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) != null) || charSequence == null || i2 != 0 || i3 != 1 || charSequence.charAt(i) != '@' || this.b.m()) {
                return;
            }
            AtListActivityConfig atListActivityConfig = new AtListActivityConfig(this.b.a, 12004, true);
            atListActivityConfig.setSelectedAtUid(TextUtils.join(",", this.a.getAtUidList()));
            if (this.b.p() > 0) {
                atListActivityConfig.setFromFid(String.valueOf(this.b.p()));
            }
            atListActivityConfig.setCallAtListSource(AtListActivityConfig.GROUP_CHAT_PAGE);
            atListActivityConfig.setIsForGroupChat(true);
            atListActivityConfig.setChatroomId(this.b.o());
            atListActivityConfig.setUserRole(this.b.u());
            atListActivityConfig.setForumId(this.b.p());
            atListActivityConfig.setForumName(this.b.q());
            atListActivityConfig.setIsShowBotInfo(this.b.j);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, atListActivityConfig));
            TiebaStatic.log(new StatisticItem("c15130").param("fid", this.b.p()).param("room_id", this.b.o()).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    /* loaded from: classes8.dex */
    public class f implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpanGroupEditText a;
        public final /* synthetic */ uc8 b;

        public f(uc8 uc8Var, SpanGroupEditText spanGroupEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uc8Var, spanGroupEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = uc8Var;
            this.a = spanGroupEditText;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (this.b.f != null && motionEvent.getAction() == 1) {
                    this.b.f.D(new wi5(5, -1, null));
                    this.a.requestFocus();
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    public uc8(@Nullable Context context, @NonNull GroupInputViewController groupInputViewController) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, groupInputViewController};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = new LinkedHashMap();
        this.h = new LinkedHashMap();
        this.j = true;
        this.k = true;
        this.m = new a(this);
        this.n = new b(this, 2921777);
        this.o = new c(this, 2921785);
        this.a = context;
        this.b = groupInputViewController;
        MessageManager.getInstance().registerListener(this.n);
        MessageManager.getInstance().registerListener(this.o);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void D(@Nullable SpanGroupEditText spanGroupEditText) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, spanGroupEditText) != null) || spanGroupEditText == null) {
            return;
        }
        spanGroupEditText.addTextChangedListener(new e(this, spanGroupEditText));
        spanGroupEditText.setOnTouchListener(new f(this, spanGroupEditText));
    }

    public void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.g.remove(str);
            z();
        }
    }

    public void I(ToolState toolState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, toolState) == null) {
            this.i = toolState;
        }
    }

    public void K(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.k = z;
        }
    }

    public final void M(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048588, this, z) == null) && z) {
            C();
        }
    }

    public void E(String str, AtSelectData atSelectData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, atSelectData) == null) {
            this.g.put(str, atSelectData);
            z();
        }
    }

    public void H(ArrayList<AtSelectData> arrayList, boolean z) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048583, this, arrayList, z) == null) && (editorTools = this.f) != null) {
            editorTools.D(new wi5(17, -1, arrayList));
            M(z);
        }
    }

    public void J(GroupInputTool groupInputTool, EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, groupInputTool, editorTools) == null) {
            this.e = groupInputTool;
            this.f = editorTools;
            D(s());
        }
    }

    public void O(pd8 pd8Var, md8 md8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, pd8Var, md8Var) == null) {
            this.c = pd8Var;
            this.d = md8Var;
        }
    }

    public void k(@NonNull AtSelectData atSelectData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048591, this, atSelectData, z) == null) {
            l(atSelectData, z, false, true);
        }
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.n);
            MessageManager.getInstance().unRegisterListener(this.o);
            SafeHandler.getInst().removeCallbacks(this.m);
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && s() != null && s().getSpanGroupManager() != null) {
            SpanGroupEditText s = s();
            s.setOnSpanGroupChangedListener(new d(this, s));
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.g.clear();
            z();
        }
    }

    public void L() {
        Context context;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (context = this.a) != null) {
            BdToast.makeText(context, context.getString(R.string.obfuscated_res_0x7f0f0944)).setIcon(R.drawable.icon_toast_game_error).show();
        }
    }

    public Map<String, Integer> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return Collections.unmodifiableMap(this.h);
        }
        return (Map) invokeV.objValue;
    }

    public long o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            pd8 pd8Var = this.c;
            if (pd8Var == null) {
                return 0L;
            }
            return pd8Var.d();
        }
        return invokeV.longValue;
    }

    public long p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            md8 md8Var = this.d;
            if (md8Var == null) {
                return 0L;
            }
            return md8Var.a();
        }
        return invokeV.longValue;
    }

    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            md8 md8Var = this.d;
            if (md8Var == null) {
                return StringUtil.NULL_STRING;
            }
            return md8Var.b();
        }
        return (String) invokeV.objValue;
    }

    public ToolState r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.i;
        }
        return (ToolState) invokeV.objValue;
    }

    @Nullable
    public List<AtSelectData> t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            GroupInputTool groupInputTool = this.e;
            if (groupInputTool != null && groupInputTool.L() != null) {
                return this.e.L().h();
            }
            return Collections.emptyList();
        }
        return (List) invokeV.objValue;
    }

    public int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            pd8 pd8Var = this.c;
            if (pd8Var == null) {
                return 0;
            }
            return pd8Var.a();
        }
        return invokeV.intValue;
    }

    public Map<String, AtSelectData> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.g;
        }
        return (Map) invokeV.objValue;
    }

    public final void z() {
        yc8 R0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048606, this) == null) && (R0 = this.b.R0()) != null) {
            R0.O(new ArrayList(this.g.values()));
        }
    }

    public void C() {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f != null && s() != null && (groupInputTool = this.e) != null && !groupInputTool.c0()) {
            this.f.D(new wi5(5, -1, null));
            s().setFocusable(true);
            s().setFocusableInTouchMode(true);
            s().requestFocus();
            SafeHandler.getInst().postDelayed(this.m, 100L);
        }
    }

    @Nullable
    public SpanGroupEditText s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            GroupInputTool groupInputTool = this.e;
            if (groupInputTool != null && groupInputTool.L() != null && this.e.L().g() != null && this.e.L().g().getSpanGroupManager() != null) {
                return this.e.L().g();
            }
            return null;
        }
        return (SpanGroupEditText) invokeV.objValue;
    }

    public void N(List<AtSelectData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, list) == null) {
            if (ListUtils.isEmpty(list)) {
                G();
                return;
            }
            G();
            for (AtSelectData atSelectData : list) {
                if (atSelectData != null) {
                    E(atSelectData.getUid(), atSelectData);
                }
            }
        }
    }

    public void l(@NonNull AtSelectData atSelectData, boolean z, boolean z2, boolean z3) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{atSelectData, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            M(z3);
            String uid = atSelectData.getUid();
            if (!z2 && TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(uid)) {
                return;
            }
            if (this.g.containsKey(uid) && this.b.M0() != null && this.b.M0().b0()) {
                F(uid);
            }
            if (!this.g.containsKey(uid)) {
                E(uid, atSelectData);
                if (atSelectData.isRobot()) {
                    this.b.v1();
                }
                H(new ArrayList<>(this.g.values()), z3);
                if (atSelectData.isRobot() && (groupInputTool = this.e) != null) {
                    if (z && groupInputTool.c0()) {
                        this.b.s0(true, 3);
                    } else if (z) {
                        this.l = true;
                    }
                }
            }
        }
    }

    public final boolean m() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            Context context = this.a;
            if (context == null) {
                return false;
            }
            String string = context.getString(R.string.obfuscated_res_0x7f0f09c0);
            List<InputBanData> J0 = this.b.J0();
            if (!J0.isEmpty()) {
                z = false;
                for (InputBanData inputBanData : J0) {
                    if (inputBanData != null && "at".equals(inputBanData.getBanType())) {
                        if (TextUtils.isEmpty(inputBanData.getBanToast())) {
                            string = this.a.getString(R.string.obfuscated_res_0x7f0f09c0);
                        } else {
                            string = inputBanData.getBanToast();
                        }
                        z = true;
                    }
                }
            } else {
                z = false;
            }
            if (this.b.M0() == null || this.b.M0().H() == null || string == null || !StringUtils.isNotNull(string) || !this.b.l1() || !z) {
                return false;
            }
            this.b.M0().H().b(string, false);
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) {
            if (t() != null && !ListUtils.isEmpty(t())) {
                for (AtSelectData atSelectData : t()) {
                    if (atSelectData != null && atSelectData.isRobot() && atSelectData.getUid().equals(str)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void x(@NonNull AtSelectData atSelectData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, atSelectData) == null) {
            if (this.f != null && r() == ToolState.VOICE) {
                this.f.D(new wi5(1, 3, null));
            }
            if (w(atSelectData.getUid()) && atSelectData.isRobot()) {
                return;
            }
            if ((!ListUtils.isEmpty(t()) && atSelectData.isRobot()) || !this.k || m()) {
                return;
            }
            if (this.g.size() < 5) {
                k(atSelectData, true);
            } else {
                L();
            }
            TiebaStatic.log(new StatisticItem("c15129").param("fid", p()).param("room_id", o()).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048605, this) == null) && s() != null && s().getText() != null) {
            SpanGroupEditText s = s();
            String plainTextContent = s.getPlainTextContent();
            this.h.clear();
            for (pb5 pb5Var : s.getSpanGroupManager().w()) {
                if (!StringUtils.isNull(plainTextContent) && pb5Var != null) {
                    int indexOf = plainTextContent.indexOf(pb5Var.x());
                    this.h.put(pb5Var.w().getUid(), Integer.valueOf(indexOf));
                    plainTextContent = plainTextContent.replace(pb5Var.x(), pb5Var.y());
                }
            }
        }
    }
}
