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
import com.baidu.tieba.h85;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.GroupChatFragment;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.ability.InputBoxHandler;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.GroupInputTool;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.GroupInputViewController;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.ToolState;
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
/* loaded from: classes7.dex */
public class u98 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public GroupChatFragment b;
    @Nullable
    public GroupInputTool c;
    @Nullable
    public EditorTools d;
    public final Map<String, AtSelectData> e;
    public final Map<String, Integer> f;
    public ToolState g;
    public boolean h;
    public boolean i;
    public boolean j;
    public final Runnable k;
    public final CustomMessageListener l;
    public final CustomMessageListener m;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u98 a;

        public a(u98 u98Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u98Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u98Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ri.O(this.a.a, this.a.s());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u98 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(u98 u98Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u98Var, Integer.valueOf(i)};
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
            this.a = u98Var;
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

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u98 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(u98 u98Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u98Var, Integer.valueOf(i)};
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
            this.a = u98Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean) || !((Boolean) customResponsedMessage.getData()).booleanValue() || !this.a.j || this.a.b == null || this.a.b.l2() == null) {
                return;
            }
            this.a.j = false;
            this.a.b.l2().q0(true, 3);
        }
    }

    /* loaded from: classes7.dex */
    public class d implements h85.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpanGroupEditText a;
        public final /* synthetic */ u98 b;

        public d(u98 u98Var, SpanGroupEditText spanGroupEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u98Var, spanGroupEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = u98Var;
            this.a = spanGroupEditText;
        }

        @Override // com.baidu.tieba.h85.a
        public void d(int i, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) && this.b.e.size() != ListUtils.getCount(this.a.getSpanGroupManager().w())) {
                this.b.N(this.a.getSpanGroupManager().w());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpanGroupEditText a;
        public final /* synthetic */ u98 b;

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
            }
        }

        public e(u98 u98Var, SpanGroupEditText spanGroupEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u98Var, spanGroupEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = u98Var;
            this.a = spanGroupEditText;
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
                if (charSequence == null || lt5.b(this.a) <= 0) {
                    this.b.h = true;
                } else {
                    this.b.h = false;
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
            atListActivityConfig.setIsShowBotInfo(this.b.h);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, atListActivityConfig));
            TiebaStatic.log(new StatisticItem("c15130").param("fid", this.b.p()).param("room_id", this.b.o()).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    /* loaded from: classes7.dex */
    public class f implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpanGroupEditText a;
        public final /* synthetic */ u98 b;

        public f(u98 u98Var, SpanGroupEditText spanGroupEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u98Var, spanGroupEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = u98Var;
            this.a = spanGroupEditText;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (this.b.d != null && motionEvent.getAction() == 1) {
                    this.b.d.C(new se5(5, -1, null));
                    this.a.requestFocus();
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    public u98(Context context, GroupChatFragment groupChatFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, groupChatFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new LinkedHashMap();
        this.f = new LinkedHashMap();
        this.h = true;
        this.i = true;
        this.k = new a(this);
        this.l = new b(this, 2921777);
        this.m = new c(this, 2921785);
        this.a = context;
        this.b = groupChatFragment;
        MessageManager.getInstance().registerListener(this.l);
        MessageManager.getInstance().registerListener(this.m);
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
            this.e.remove(str);
            z();
        }
    }

    public void I(ToolState toolState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, toolState) == null) {
            this.g = toolState;
        }
    }

    public void K(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.i = z;
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
            this.e.put(str, atSelectData);
            z();
        }
    }

    public void H(ArrayList<AtSelectData> arrayList, boolean z) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048583, this, arrayList, z) == null) && (editorTools = this.d) != null) {
            editorTools.C(new se5(17, -1, arrayList));
            M(z);
        }
    }

    public void J(GroupInputTool groupInputTool, EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, groupInputTool, editorTools) == null) {
            this.c = groupInputTool;
            this.d = editorTools;
            D(s());
        }
    }

    public void k(@NonNull AtSelectData atSelectData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048590, this, atSelectData, z) == null) {
            l(atSelectData, z, false, true);
        }
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.l);
            MessageManager.getInstance().unRegisterListener(this.m);
            sg.a().removeCallbacks(this.k);
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
            this.e.clear();
            z();
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            Context context = this.a;
            BdToast b2 = BdToast.b(context, context.getString(R.string.obfuscated_res_0x7f0f08ee));
            b2.f(R.drawable.icon_toast_game_error);
            b2.o();
        }
    }

    public Map<String, Integer> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return Collections.unmodifiableMap(this.f);
        }
        return (Map) invokeV.objValue;
    }

    public long o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            GroupChatFragment groupChatFragment = this.b;
            if (groupChatFragment == null) {
                return 0L;
            }
            return groupChatFragment.i2();
        }
        return invokeV.longValue;
    }

    public long p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            GroupChatFragment groupChatFragment = this.b;
            if (groupChatFragment == null) {
                return 0L;
            }
            return groupChatFragment.g2();
        }
        return invokeV.longValue;
    }

    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            GroupChatFragment groupChatFragment = this.b;
            if (groupChatFragment == null) {
                return StringUtil.NULL_STRING;
            }
            return groupChatFragment.h2();
        }
        return (String) invokeV.objValue;
    }

    public ToolState r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.g;
        }
        return (ToolState) invokeV.objValue;
    }

    @Nullable
    public List<AtSelectData> t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            GroupInputTool groupInputTool = this.c;
            if (groupInputTool != null && groupInputTool.H() != null) {
                return this.c.H().h();
            }
            return Collections.emptyList();
        }
        return (List) invokeV.objValue;
    }

    public int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            GroupChatFragment groupChatFragment = this.b;
            if (groupChatFragment == null) {
                return 0;
            }
            return groupChatFragment.k2();
        }
        return invokeV.intValue;
    }

    public Map<String, AtSelectData> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.e;
        }
        return (Map) invokeV.objValue;
    }

    public void C() {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.d != null && s() != null && (groupInputTool = this.c) != null && !groupInputTool.a0()) {
            this.d.C(new se5(5, -1, null));
            s().setFocusable(true);
            s().setFocusableInTouchMode(true);
            s().requestFocus();
            sg.a().postDelayed(this.k, 100L);
        }
    }

    @Nullable
    public SpanGroupEditText s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            GroupInputTool groupInputTool = this.c;
            if (groupInputTool != null && groupInputTool.H() != null && this.c.H().g() != null && this.c.H().g().getSpanGroupManager() != null) {
                return this.c.H().g();
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
        GroupChatFragment groupChatFragment;
        GroupChatFragment groupChatFragment2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{atSelectData, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            M(z3);
            String uid = atSelectData.getUid();
            if (!z2 && TbadkCoreApplication.getCurrentAccount().equals(uid)) {
                return;
            }
            if (this.e.containsKey(uid) && (groupChatFragment2 = this.b) != null && groupChatFragment2.e2() != null && this.b.e2().Z()) {
                F(uid);
            }
            if (!this.e.containsKey(uid)) {
                E(uid, atSelectData);
                if (atSelectData.isRobot() && (groupChatFragment = this.b) != null && groupChatFragment.l2() != null) {
                    this.b.l2().n1();
                }
                H(new ArrayList<>(this.e.values()), z3);
                if (atSelectData.isRobot() && (groupInputTool = this.c) != null) {
                    if (z && this.b != null && groupInputTool.a0() && this.b.l2() != null) {
                        this.b.l2().q0(true, 3);
                    } else if (z) {
                        this.j = true;
                    }
                }
            }
        }
    }

    public final boolean m() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            GroupInputViewController l2 = this.b.l2();
            String string = this.b.getString(R.string.obfuscated_res_0x7f0f0968);
            if (l2 != null) {
                List<InputBoxHandler.BanData> E0 = l2.E0();
                if (!E0.isEmpty()) {
                    z = false;
                    for (InputBoxHandler.BanData banData : E0) {
                        if (banData != null && "at".equals(banData.getBanType())) {
                            if (TextUtils.isEmpty(banData.getBanToast())) {
                                string = this.b.getString(R.string.obfuscated_res_0x7f0f0968);
                            } else {
                                string = banData.getBanToast();
                            }
                            z = true;
                        }
                    }
                    if (l2 != null || !l2.d1() || !z || this.b.f2() == null) {
                        return false;
                    }
                    this.b.f2().o1(string, false);
                    return true;
                }
            }
            z = false;
            if (l2 != null) {
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void y() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048604, this) == null) && s() != null && s().getText() != null) {
            SpanGroupEditText s = s();
            String plainTextContent = s.getPlainTextContent();
            this.f.clear();
            for (l85 l85Var : s.getSpanGroupManager().x()) {
                if (!StringUtils.isNull(plainTextContent) && l85Var != null) {
                    int indexOf = plainTextContent.indexOf(l85Var.x());
                    this.f.put(l85Var.w().getUid(), Integer.valueOf(indexOf));
                    plainTextContent = plainTextContent.replace(l85Var.x(), l85Var.y());
                }
            }
        }
    }

    public boolean w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, str)) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048603, this, atSelectData) == null) {
            if (this.d != null && r() == ToolState.VOICE) {
                this.d.C(new se5(1, 3, null));
            }
            if (w(atSelectData.getUid()) && atSelectData.isRobot()) {
                return;
            }
            if ((!ListUtils.isEmpty(t()) && atSelectData.isRobot()) || !this.i || m()) {
                return;
            }
            if (this.e.size() < 5) {
                k(atSelectData, true);
            } else {
                L();
            }
            TiebaStatic.log(new StatisticItem("c15129").param("fid", p()).param("room_id", o()).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public final void z() {
        GroupChatFragment groupChatFragment;
        w98 K0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048605, this) == null) && (groupChatFragment = this.b) != null && groupChatFragment.l2() != null && (K0 = this.b.l2().K0()) != null) {
            K0.J(new ArrayList(this.e.values()));
        }
    }
}
