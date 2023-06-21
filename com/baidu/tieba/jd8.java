package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.immessagecenter.chatgroup.data.ChatGroupInfo;
import com.baidu.tieba.immessagecenter.chatgroup.data.ChatRoomInfo;
import com.baidu.tieba.pi8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class jd8 implements nd8, pd8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public TbPageContext a;
    public CustomMessageListener b;
    public boolean c;
    public long d;
    public boolean e;
    public qd8 f;
    public final pi8.a g;
    public List<ld8> h;
    public List<ld8> i;
    public pd8 j;

    /* loaded from: classes6.dex */
    public class a implements pi8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jd8 a;

        public a(jd8 jd8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jd8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jd8Var;
        }

        @Override // com.baidu.tieba.pi8.a
        public void a(CustomResponsedMessage customResponsedMessage) {
            zd8 zd8Var;
            ChatRoomInfo a;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921766 && (customResponsedMessage.getData() instanceof Map)) {
                Map map = (Map) customResponsedMessage.getData();
                for (ld8 ld8Var : this.a.h) {
                    if ((ld8Var instanceof zd8) && (a = (zd8Var = (zd8) ld8Var).a()) != null && map.containsKey(Long.valueOf(a.getRoomId()))) {
                        zd8Var.c((ChatRoomInfo) map.get(Long.valueOf(a.getRoomId())));
                    }
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public jd8(@NonNull TbPageContext tbPageContext, long j, boolean z) {
        this(tbPageContext, j, false, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r8;
            Object[] objArr = {tbPageContext, Long.valueOf(j), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((TbPageContext) objArr2[0], ((Long) objArr2[1]).longValue(), ((Boolean) objArr2[2]).booleanValue(), ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public jd8(@NonNull TbPageContext tbPageContext, long j, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Long.valueOf(j), Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.g = new a(this);
        this.h = new ArrayList();
        this.i = new ArrayList();
        this.a = tbPageContext;
        this.c = z;
        this.d = j;
        this.e = z2;
    }

    @Override // com.baidu.tieba.nd8
    public void c(@NonNull pd8 pd8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pd8Var) == null) {
            this.j = pd8Var;
        }
    }

    public void h(List<ld8> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.h.clear();
        this.h.addAll(list);
        this.j.f(0, d());
    }

    public void p(qd8 qd8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, qd8Var) == null) {
            this.f = qd8Var;
        }
    }

    @Override // com.baidu.tieba.pd8
    public void a(int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) && i >= 0 && i2 > 0) {
            getItemsCount();
            int i3 = (i2 + i) - 1;
            int i4 = 0;
            while (i3 >= i && i3 < getItemsCount()) {
                this.h.remove(i3);
                i3--;
                i4++;
            }
            pd8 pd8Var = this.j;
            if (pd8Var != null) {
                pd8Var.a(i, i4);
            }
        }
    }

    public void j(List<?> list, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048586, this, list, z) == null) && !ListUtils.isEmpty(list) && this.j != null) {
            this.e = z;
            List<ld8> m = m(list);
            if (m == null) {
                return;
            }
            this.h.clear();
            this.h.addAll(m);
            this.j.f(0, d());
        }
    }

    public void k(List<?> list, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048587, this, list, z) == null) && !ListUtils.isEmpty(list) && this.j != null) {
            this.e = z;
            List<ld8> m = m(list);
            if (ListUtils.isEmpty(m)) {
                return;
            }
            int itemsCount = getItemsCount();
            this.h.clear();
            this.j.a(0, itemsCount);
            this.h.addAll(m);
            this.j.b(0, d());
        }
    }

    @Override // com.baidu.tieba.pd8
    public void b(int i, @NonNull List<ld8> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, list) == null) && this.j != null && !ListUtils.isEmpty(list)) {
            this.j.b(i, list);
        }
    }

    @Override // com.baidu.tieba.pd8
    public void f(int i, @NonNull List<ld8> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048582, this, i, list) != null) || list.isEmpty()) {
            return;
        }
        this.h.addAll(i, list);
        pd8 pd8Var = this.j;
        if (pd8Var != null) {
            pd8Var.f(i, list);
        }
    }

    @Override // com.baidu.tieba.nd8
    @NonNull
    public List<ld8> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return Collections.unmodifiableList(this.h);
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.nd8
    public void detach() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.b != null) {
            MessageManager.getInstance().unRegisterListener(this.b);
        }
    }

    @Override // com.baidu.tieba.nd8
    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.c) {
            if (this.b == null) {
                this.b = new pi8(2921766, this.g);
            }
            MessageManager.getInstance().registerListener(this.b);
        }
    }

    @Override // com.baidu.tieba.nd8
    public int getItemsCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.h.size();
        }
        return invokeV.intValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || ListUtils.isEmpty(this.h)) {
            return;
        }
        b(0, d());
    }

    public void o() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048591, this) != null) || ListUtils.isEmpty(this.h)) {
            return;
        }
        this.i.clear();
        this.i.addAll(new ArrayList(this.h));
        this.h.clear();
    }

    @Nullable
    public final yd8 i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (ListUtils.isEmpty(this.i)) {
                return null;
            }
            for (ld8 ld8Var : this.i) {
                if ((ld8Var instanceof yd8) && str != null) {
                    yd8 yd8Var = (yd8) ld8Var;
                    if (str.equals(yd8Var.a())) {
                        return yd8Var;
                    }
                }
            }
            return null;
        }
        return (yd8) invokeL.objValue;
    }

    @Nullable
    public final List<zd8> n(@Nullable List list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                Object obj = list.get(i);
                if (obj instanceof ChatRoomInfo) {
                    arrayList.add(new zd8((ChatRoomInfo) obj, this.e));
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @Nullable
    public final List<ld8> m(@Nullable List list) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                Object obj = list.get(i);
                if (obj instanceof ChatGroupInfo) {
                    ChatGroupInfo chatGroupInfo = (ChatGroupInfo) obj;
                    List<zd8> n = n(chatGroupInfo.getRoomInfoList());
                    if (n != null) {
                        if (TextUtils.isEmpty(chatGroupInfo.getName())) {
                            arrayList.add(0, new yd8(n, "", "", false, true, this.e, this.a, this.f));
                        } else {
                            yd8 i2 = i(chatGroupInfo.getGroupId());
                            String name = chatGroupInfo.getName();
                            String groupId = chatGroupInfo.getGroupId();
                            if (i2 != null && i2.d()) {
                                z = true;
                            } else {
                                z = false;
                            }
                            arrayList.add(new yd8(n, name, groupId, z, this.e, this.a, this.f));
                        }
                    }
                } else if (obj instanceof ae8) {
                    ae8 ae8Var = (ae8) obj;
                    arrayList.add(new xd8(ae8Var.a(), ae8Var.b(), this.d));
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
