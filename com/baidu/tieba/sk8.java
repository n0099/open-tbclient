package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.chatmessage.IChatRoomEnterListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.data.ChatRoomInfoData;
import com.baidu.tieba.immessagecenter.chatgroup.chatbox.ChatGroupSource;
import com.baidu.tieba.immessagecenter.chatgroup.data.ChatRoomInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes7.dex */
public class sk8 extends ui8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long m;
    public final Set<Long> n;
    public boolean o;
    @Nullable
    public final tk8 p;
    @Nullable
    public uk8 q;
    public final CustomMessageListener r;

    @Override // com.baidu.tieba.ui8
    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ui8
    public long l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 0L;
        }
        return invokeV.longValue;
    }

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sk8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(sk8 sk8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sk8Var, Integer.valueOf(i)};
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
            this.a = sk8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Map map;
            ChatRoomInfo chatRoomInfo;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && !customResponsedMessage.hasError() && (customResponsedMessage.getData() instanceof Map) && (map = (Map) customResponsedMessage.getData()) != null && !map.isEmpty() && (chatRoomInfo = (ChatRoomInfo) map.get(Long.valueOf(this.a.m))) != null && this.a.p != null) {
                this.a.p.a(chatRoomInfo);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements bp5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sk8 a;

        public b(sk8 sk8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sk8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sk8Var;
        }

        @Override // com.baidu.tieba.bp5
        public void a(long j, int i, @NonNull String str, @Nullable IChatRoomEnterListener.ChatRoomInfo chatRoomInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), str, chatRoomInfo}) == null) {
                this.a.n.add(Long.valueOf(j));
                if (this.a.q != null && i == 0) {
                    this.a.q.b(j);
                }
                this.a.o = true;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements cp5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sk8 a;

        public c(sk8 sk8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sk8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sk8Var;
        }

        @Override // com.baidu.tieba.cp5
        public void a(long j, int i, @NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), str}) == null) {
                this.a.n.remove(Long.valueOf(j));
                if (this.a.q != null && i == -200) {
                    this.a.q.a(j);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sk8(@NonNull Context context, @Nullable tk8 tk8Var) {
        super(context, ChatGroupSource.GROUP_CHAT_FLOAT);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, tk8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (ChatGroupSource) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = 0L;
        this.n = new HashSet();
        this.r = new a(this, 2921766);
        this.p = tk8Var;
        MessageManager.getInstance().registerListener(this.r);
    }

    public boolean F(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) {
            return this.n.contains(Long.valueOf(j));
        }
        return invokeJ.booleanValue;
    }

    public void G(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            w(j, 0);
        }
    }

    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.o;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ui8
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.o();
            this.o = false;
            this.n.clear();
            t(null);
            v(null);
            MessageManager.getInstance().unRegisterListener(this.r);
        }
    }

    public void E(List<ChatRoomInfoData> list, long j, @Nullable uk8 uk8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{list, Long.valueOf(j), uk8Var}) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.m = j;
        this.q = uk8Var;
        n(xk8.c(list));
        this.f = new b(this);
        this.g = new c(this);
        t(this.f);
        v(this.g);
    }
}
