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
import com.baidu.tieba.e55;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.GroupChatFragment;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.GroupInputTool;
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
/* loaded from: classes6.dex */
public class uv7 {
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

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uv7 a;

        public a(uv7 uv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uv7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                hi.O(this.a.a, this.a.q());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uv7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(uv7 uv7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uv7Var, Integer.valueOf(i)};
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
            this.a = uv7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && !customResponsedMessage.hasError() && (customResponsedMessage.getData() instanceof AtSelectData)) {
                this.a.w((AtSelectData) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uv7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(uv7 uv7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uv7Var, Integer.valueOf(i)};
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
            this.a = uv7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean) || !((Boolean) customResponsedMessage.getData()).booleanValue() || !this.a.j || this.a.c == null || this.a.c.O() == null || this.a.c.F() == null) {
                return;
            }
            this.a.j = false;
            this.a.c.O().requestFocus();
            this.a.c.F().q(null, 3);
        }
    }

    /* loaded from: classes6.dex */
    public class d implements e55.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpanGroupEditText a;
        public final /* synthetic */ uv7 b;

        public d(uv7 uv7Var, SpanGroupEditText spanGroupEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uv7Var, spanGroupEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = uv7Var;
            this.a = spanGroupEditText;
        }

        @Override // com.baidu.tieba.e55.a
        public void c(int i, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) && this.b.e.size() != ListUtils.getCount(this.a.getSpanGroupManager().w())) {
                this.b.H(this.a.getSpanGroupManager().w());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpanGroupEditText a;
        public final /* synthetic */ uv7 b;

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
            }
        }

        public e(uv7 uv7Var, SpanGroupEditText spanGroupEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uv7Var, spanGroupEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = uv7Var;
            this.a = spanGroupEditText;
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
                if (charSequence == null || dq5.c(this.a) <= 0) {
                    this.b.h = true;
                } else {
                    this.b.h = false;
                }
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) && charSequence != null && i2 == 0 && i3 == 1 && charSequence.charAt(i) == '@') {
                AtListActivityConfig atListActivityConfig = new AtListActivityConfig(this.b.a, 12004, true);
                atListActivityConfig.setSelectedAtUid(TextUtils.join(",", this.a.getAtUidList()));
                if (this.b.n() > 0) {
                    atListActivityConfig.setFromFid(String.valueOf(this.b.n()));
                }
                atListActivityConfig.setIsForGroupChat(true);
                atListActivityConfig.setChatroomId(this.b.m());
                atListActivityConfig.setUserRole(this.b.t());
                atListActivityConfig.setForumId(this.b.n());
                atListActivityConfig.setForumName(this.b.o());
                atListActivityConfig.setIsShowBotInfo(this.b.h);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, atListActivityConfig));
                TiebaStatic.log(new StatisticItem("c15130").param("fid", this.b.n()).param("room_id", this.b.m()).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpanGroupEditText a;
        public final /* synthetic */ uv7 b;

        public f(uv7 uv7Var, SpanGroupEditText spanGroupEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uv7Var, spanGroupEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = uv7Var;
            this.a = spanGroupEditText;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (this.b.d != null && motionEvent.getAction() == 1) {
                    this.b.d.C(new lb5(5, -1, null));
                    this.a.requestFocus();
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    public uv7(Context context, GroupChatFragment groupChatFragment) {
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
    public final void B(@Nullable SpanGroupEditText spanGroupEditText) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, spanGroupEditText) != null) || spanGroupEditText == null) {
            return;
        }
        spanGroupEditText.addTextChangedListener(new e(this, spanGroupEditText));
        spanGroupEditText.setOnTouchListener(new f(this, spanGroupEditText));
    }

    public void D(ArrayList<AtSelectData> arrayList) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) && (editorTools = this.d) != null) {
            editorTools.C(new lb5(17, -1, arrayList));
            A();
        }
    }

    public void E(ToolState toolState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, toolState) == null) {
            this.g = toolState;
        }
    }

    public void F(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.i = z;
        }
    }

    public void j(@NonNull AtSelectData atSelectData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, atSelectData, z) == null) {
            k(atSelectData, z, false);
        }
    }

    public void r(GroupInputTool groupInputTool, EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, groupInputTool, editorTools) == null) {
            this.c = groupInputTool;
            this.d = editorTools;
            B(q());
        }
    }

    public void A() {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.d != null && q() != null && (groupInputTool = this.c) != null && !groupInputTool.V()) {
            this.d.C(new lb5(5, -1, null));
            q().setFocusable(true);
            q().setFocusableInTouchMode(true);
            q().requestFocus();
            jg.a().postDelayed(this.k, 100L);
        }
    }

    @Nullable
    public SpanGroupEditText q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            GroupInputTool groupInputTool = this.c;
            if (groupInputTool != null && groupInputTool.C() != null && this.c.C().g() != null && this.c.C().g().getSpanGroupManager() != null) {
                return this.c.C().g();
            }
            return null;
        }
        return (SpanGroupEditText) invokeV.objValue;
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.e.clear();
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Context context = this.a;
            BdToast b2 = BdToast.b(context, context.getString(R.string.obfuscated_res_0x7f0f0878));
            b2.f(R.drawable.icon_toast_game_error);
            b2.k();
        }
    }

    public Map<String, Integer> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return Collections.unmodifiableMap(this.f);
        }
        return (Map) invokeV.objValue;
    }

    public long m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            GroupChatFragment groupChatFragment = this.b;
            if (groupChatFragment == null) {
                return 0L;
            }
            return groupChatFragment.h2();
        }
        return invokeV.longValue;
    }

    public long n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            GroupChatFragment groupChatFragment = this.b;
            if (groupChatFragment == null) {
                return 0L;
            }
            return groupChatFragment.f2();
        }
        return invokeV.longValue;
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            GroupChatFragment groupChatFragment = this.b;
            if (groupChatFragment == null) {
                return StringUtil.NULL_STRING;
            }
            return groupChatFragment.g2();
        }
        return (String) invokeV.objValue;
    }

    public ToolState p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.g;
        }
        return (ToolState) invokeV.objValue;
    }

    @Nullable
    public List<AtSelectData> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            GroupInputTool groupInputTool = this.c;
            if (groupInputTool != null && groupInputTool.C() != null) {
                return this.c.C().h();
            }
            return Collections.emptyList();
        }
        return (List) invokeV.objValue;
    }

    public int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            GroupChatFragment groupChatFragment = this.b;
            if (groupChatFragment == null) {
                return 0;
            }
            return groupChatFragment.j2();
        }
        return invokeV.intValue;
    }

    public Map<String, AtSelectData> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.e;
        }
        return (Map) invokeV.objValue;
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.l);
            MessageManager.getInstance().unRegisterListener(this.m);
            jg.a().removeCallbacks(this.k);
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && q() != null && q().getSpanGroupManager() != null) {
            SpanGroupEditText q = q();
            q.setOnSpanGroupChangedListener(new d(this, q));
        }
    }

    public void H(List<AtSelectData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            if (ListUtils.isEmpty(list)) {
                C();
                return;
            }
            C();
            for (AtSelectData atSelectData : list) {
                if (atSelectData != null) {
                    this.e.put(atSelectData.getUid(), atSelectData);
                }
            }
        }
    }

    public void k(@NonNull AtSelectData atSelectData, boolean z, boolean z2) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{atSelectData, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            A();
            String uid = atSelectData.getUid();
            if ((z2 || !TbadkCoreApplication.getCurrentAccount().equals(uid)) && !this.e.containsKey(uid)) {
                this.e.put(uid, atSelectData);
                D(new ArrayList<>(this.e.values()));
                if (atSelectData.isRobot() && (groupInputTool = this.c) != null) {
                    if (z && groupInputTool.O() != null && this.c.V() && this.c.F() != null) {
                        this.c.O().requestFocus();
                        this.c.F().q(null, 3);
                    } else if (z) {
                        this.j = true;
                    }
                }
            }
        }
    }

    public boolean v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
            if (s() != null && !ListUtils.isEmpty(s())) {
                for (AtSelectData atSelectData : s()) {
                    if (atSelectData != null && atSelectData.isRobot() && atSelectData.getUid().equals(str)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void w(@NonNull AtSelectData atSelectData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, atSelectData) == null) {
            if (this.d != null && p() == ToolState.VOICE) {
                this.d.C(new lb5(1, 3, null));
            }
            if (v(atSelectData.getUid()) && atSelectData.isRobot()) {
                return;
            }
            if ((!ListUtils.isEmpty(s()) && atSelectData.isRobot()) || !this.i) {
                return;
            }
            if (this.e.size() < 5) {
                j(atSelectData, true);
            } else {
                G();
            }
            TiebaStatic.log(new StatisticItem("c15129").param("fid", n()).param("room_id", m()).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && q() != null && q().getText() != null) {
            SpanGroupEditText q = q();
            String plainTextContent = q.getPlainTextContent();
            this.f.clear();
            for (i55 i55Var : q.getSpanGroupManager().x()) {
                if (!StringUtils.isNull(plainTextContent) && i55Var != null) {
                    int indexOf = plainTextContent.indexOf(i55Var.x());
                    this.f.put(i55Var.w().getUid(), Integer.valueOf(indexOf));
                    plainTextContent = plainTextContent.replace(i55Var.x(), i55Var.y());
                }
            }
        }
    }
}
