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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class tc8 implements xc8, zc8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public TbPageContext a;
    public CustomMessageListener b;
    public boolean c;
    public long d;
    public boolean e;
    public ad8 f;
    public List<vc8> g;
    public List<vc8> h;
    public zc8 i;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tc8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(tc8 tc8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tc8Var, Integer.valueOf(i)};
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
            this.a = tc8Var;
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            jd8 jd8Var;
            ChatRoomInfo a;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921766 && (customResponsedMessage.getData() instanceof Map)) {
                Map map = (Map) customResponsedMessage.getData();
                for (vc8 vc8Var : this.a.g) {
                    if ((vc8Var instanceof jd8) && (a = (jd8Var = (jd8) vc8Var).a()) != null && map.containsKey(Long.valueOf(a.getRoomId()))) {
                        jd8Var.c((ChatRoomInfo) map.get(Long.valueOf(a.getRoomId())));
                    }
                }
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public tc8(@NonNull TbPageContext tbPageContext, long j, boolean z) {
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

    public tc8(@NonNull TbPageContext tbPageContext, long j, boolean z, boolean z2) {
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
        this.g = new ArrayList();
        this.h = new ArrayList();
        this.a = tbPageContext;
        this.c = z;
        this.d = j;
        this.e = z2;
    }

    @Override // com.baidu.tieba.xc8
    public void c(@NonNull zc8 zc8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, zc8Var) == null) {
            this.i = zc8Var;
        }
    }

    public void h(List<vc8> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.g.clear();
        this.g.addAll(list);
        this.i.f(0, d());
    }

    public void p(ad8 ad8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, ad8Var) == null) {
            this.f = ad8Var;
        }
    }

    @Override // com.baidu.tieba.zc8
    public void a(int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) && i >= 0 && i2 > 0) {
            getItemsCount();
            int i3 = (i2 + i) - 1;
            int i4 = 0;
            while (i3 >= i && i3 < getItemsCount()) {
                this.g.remove(i3);
                i3--;
                i4++;
            }
            zc8 zc8Var = this.i;
            if (zc8Var != null) {
                zc8Var.a(i, i4);
            }
        }
    }

    public void j(List<?> list, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048586, this, list, z) == null) && !ListUtils.isEmpty(list) && this.i != null) {
            this.e = z;
            List<vc8> m = m(list);
            if (m == null) {
                return;
            }
            this.g.clear();
            this.g.addAll(m);
            this.i.f(0, d());
        }
    }

    public void k(List<?> list, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048587, this, list, z) == null) && !ListUtils.isEmpty(list) && this.i != null) {
            this.e = z;
            List<vc8> m = m(list);
            if (ListUtils.isEmpty(m)) {
                return;
            }
            int itemsCount = getItemsCount();
            this.g.clear();
            this.i.a(0, itemsCount);
            this.g.addAll(m);
            this.i.b(0, d());
        }
    }

    @Override // com.baidu.tieba.zc8
    public void b(int i, @NonNull List<vc8> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, list) == null) && this.i != null && !ListUtils.isEmpty(list)) {
            this.i.b(i, list);
        }
    }

    @Override // com.baidu.tieba.zc8
    public void f(int i, @NonNull List<vc8> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048582, this, i, list) != null) || list.isEmpty()) {
            return;
        }
        this.g.addAll(i, list);
        zc8 zc8Var = this.i;
        if (zc8Var != null) {
            zc8Var.f(i, list);
        }
    }

    @Override // com.baidu.tieba.xc8
    @NonNull
    public List<vc8> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return Collections.unmodifiableList(this.g);
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xc8
    public void detach() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.b != null) {
            MessageManager.getInstance().unRegisterListener(this.b);
        }
    }

    @Override // com.baidu.tieba.xc8
    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.c) {
            if (this.b == null) {
                this.b = new a(this, 2921766);
            }
            MessageManager.getInstance().registerListener(this.b);
        }
    }

    @Override // com.baidu.tieba.xc8
    public int getItemsCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.g.size();
        }
        return invokeV.intValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || ListUtils.isEmpty(this.g)) {
            return;
        }
        b(0, d());
    }

    public void o() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048591, this) != null) || ListUtils.isEmpty(this.g)) {
            return;
        }
        this.h.clear();
        this.h.addAll(new ArrayList(this.g));
        this.g.clear();
    }

    @Nullable
    public final id8 i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (ListUtils.isEmpty(this.h)) {
                return null;
            }
            for (vc8 vc8Var : this.h) {
                if ((vc8Var instanceof id8) && str != null) {
                    id8 id8Var = (id8) vc8Var;
                    if (str.equals(id8Var.a())) {
                        return id8Var;
                    }
                }
            }
            return null;
        }
        return (id8) invokeL.objValue;
    }

    @Nullable
    public final List<jd8> n(@Nullable List list) {
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
                    arrayList.add(new jd8((ChatRoomInfo) obj, this.e));
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @Nullable
    public final List<vc8> m(@Nullable List list) {
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
                    List<jd8> n = n(chatGroupInfo.getRoomInfoList());
                    if (n != null) {
                        if (TextUtils.isEmpty(chatGroupInfo.getName())) {
                            arrayList.add(0, new id8(n, "", "", false, true, this.e, this.a, this.f));
                        } else {
                            id8 i2 = i(chatGroupInfo.getGroupId());
                            String name = chatGroupInfo.getName();
                            String groupId = chatGroupInfo.getGroupId();
                            if (i2 != null && i2.d()) {
                                z = true;
                            } else {
                                z = false;
                            }
                            arrayList.add(new id8(n, name, groupId, z, this.e, this.a, this.f));
                        }
                    }
                } else if (obj instanceof kd8) {
                    kd8 kd8Var = (kd8) obj;
                    arrayList.add(new hd8(kd8Var.a(), kd8Var.b(), this.d));
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
