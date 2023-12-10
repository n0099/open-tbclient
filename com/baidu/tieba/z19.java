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
import com.baidu.tieba.wq8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
/* loaded from: classes9.dex */
public class z19 implements hn8, jn8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public TbPageContext a;
    public CustomMessageListener b;
    public boolean c;
    public long d;
    public boolean e;
    public kn8 f;
    public final wq8.a g;
    public List<gn8> h;
    public List<gn8> i;
    public jn8 j;

    /* loaded from: classes9.dex */
    public class a implements wq8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z19 a;

        public a(z19 z19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z19Var;
        }

        @Override // com.baidu.tieba.wq8.a
        public void a(CustomResponsedMessage customResponsedMessage) {
            e39 e39Var;
            ChatRoomInfo a;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921766 && (customResponsedMessage.getData() instanceof Map)) {
                Map map = (Map) customResponsedMessage.getData();
                for (gn8 gn8Var : this.a.h) {
                    if ((gn8Var instanceof e39) && (a = (e39Var = (e39) gn8Var).a()) != null && map.containsKey(Long.valueOf(a.getRoomId()))) {
                        e39Var.c((ChatRoomInfo) map.get(Long.valueOf(a.getRoomId())));
                    }
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public z19(@NonNull TbPageContext tbPageContext, long j, boolean z) {
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

    public z19(@NonNull TbPageContext tbPageContext, long j, boolean z, boolean z2) {
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

    @Override // com.baidu.tieba.hn8
    public void e(@NonNull jn8 jn8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jn8Var) == null) {
            this.j = jn8Var;
        }
    }

    public void h(List<gn8> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.h.clear();
        this.h.addAll(list);
        this.j.f(0, c());
    }

    public void p(kn8 kn8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, kn8Var) == null) {
            this.f = kn8Var;
        }
    }

    @Override // com.baidu.tieba.jn8
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
            jn8 jn8Var = this.j;
            if (jn8Var != null) {
                jn8Var.a(i, i4);
            }
        }
    }

    @Override // com.baidu.tieba.jn8
    public void b(int i, @NonNull List<gn8> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, list) == null) && this.j != null && !ListUtils.isEmpty(list)) {
            this.j.b(i, list);
        }
    }

    @Override // com.baidu.tieba.jn8
    public void f(int i, @NonNull List<gn8> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048582, this, i, list) != null) || list.isEmpty()) {
            return;
        }
        this.h.addAll(i, list);
        jn8 jn8Var = this.j;
        if (jn8Var != null) {
            jn8Var.f(i, list);
        }
    }

    @Override // com.baidu.tieba.hn8
    @NonNull
    public List<gn8> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return Collections.unmodifiableList(this.h);
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hn8
    public void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.c) {
            if (this.b == null) {
                this.b = new wq8(2921766, this.g);
            }
            MessageManager.getInstance().registerListener(this.b);
        }
    }

    @Override // com.baidu.tieba.hn8
    public void detach() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.b != null) {
            MessageManager.getInstance().unRegisterListener(this.b);
        }
    }

    @Override // com.baidu.tieba.hn8
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
        b(0, c());
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
    public final d39 i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (ListUtils.isEmpty(this.i)) {
                return null;
            }
            for (gn8 gn8Var : this.i) {
                if ((gn8Var instanceof d39) && str != null) {
                    d39 d39Var = (d39) gn8Var;
                    if (str.equals(d39Var.a())) {
                        return d39Var;
                    }
                }
            }
            return null;
        }
        return (d39) invokeL.objValue;
    }

    @Nullable
    public final List<e39> n(@Nullable List list) {
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
                    arrayList.add(new e39((ChatRoomInfo) obj, this.e));
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void j(List<?> list, boolean z, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{list, Boolean.valueOf(z), str}) == null) && !ListUtils.isEmpty(list) && this.j != null) {
            this.e = z;
            List<gn8> m = m(list, str);
            if (m == null) {
                return;
            }
            this.h.clear();
            this.h.addAll(m);
            this.j.f(0, c());
        }
    }

    public void k(List<?> list, boolean z, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{list, Boolean.valueOf(z), str}) == null) && !ListUtils.isEmpty(list) && this.j != null) {
            this.e = z;
            List<gn8> m = m(list, str);
            if (ListUtils.isEmpty(m)) {
                return;
            }
            int itemsCount = getItemsCount();
            this.h.clear();
            this.j.a(0, itemsCount);
            this.h.addAll(m);
            this.j.b(0, c());
        }
    }

    @Nullable
    public final List<gn8> m(@Nullable List list, String str) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, list, str)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                Object obj = list.get(i);
                if (obj instanceof ChatGroupInfo) {
                    ChatGroupInfo chatGroupInfo = (ChatGroupInfo) obj;
                    List<e39> n = n(chatGroupInfo.getRoomInfoList());
                    if (n != null) {
                        if (TextUtils.isEmpty(chatGroupInfo.getName())) {
                            arrayList.add(0, new d39(n, "", "", false, true, this.e, this.a, this.f, str));
                        } else {
                            d39 i2 = i(chatGroupInfo.getGroupId());
                            String name = chatGroupInfo.getName();
                            String groupId = chatGroupInfo.getGroupId();
                            if (i2 != null && i2.d()) {
                                z = true;
                            } else {
                                z = false;
                            }
                            arrayList.add(new d39(n, name, groupId, z, this.e, this.a, this.f, str));
                        }
                    }
                } else if (obj instanceof f39) {
                    f39 f39Var = (f39) obj;
                    arrayList.add(new c39(f39Var.a(), f39Var.b(), this.d));
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
